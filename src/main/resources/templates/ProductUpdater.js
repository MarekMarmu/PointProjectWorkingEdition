document.addEventListener('DOMContentLoaded', function() {

    // Funkce pro aktualizaci informací o produktu po výběru velikosti nebo barvy
    function updateSelectedProductInfo() {
        var selectedSize = document.getElementById('sizeSelector').value;
        var selectedColor = document.getElementById('colorSelector').value;

        // Získání datových atributů produktů
        var products = /*[[${products}]]*/ null;

        // Najítí produkt odpovídající vybrané velikosti a barvě
        var selectedProduct = products.find(product => {
            return product.size === selectedSize && product.color === selectedColor;
        });

        if (selectedProduct) {
            // Aktualizovat cenu vybraného produktu
            document.getElementById('selectedProductPrice').textContent = selectedProduct.price;

            // Aktualizovat počet kusů vybraného produktu
            document.getElementById('selectedProductPieces').textContent = selectedProduct.pieces;
        } else {
            // Produkt nebyl nalezen, takže zobrazit zprávu o nedostupnosti
            document.getElementById('selectedProductPrice').textContent = "Not available";
            document.getElementById('selectedProductPieces').textContent = "Not available";
        }
        return selectedProduct;
    }

    function changePictures() {
        var selectedProduct = updateSelectedProductInfo();
        var html = "";
        selectedProduct.images.forEach(image => {
            html += `<img src="/images/${image.id}" width="200" height="200">`;
        });
        document.getElementById('colorContainer').innerHTML = html;
    }

    function addToCart() {
        var selectedProduct = updateSelectedProductInfo();
        var url = `/cart/add/${selectedProduct.id}`;

        fetch(url, {
            method: 'POST',
            headers: {
                'X-CSRF-TOKEN': document.querySelector('input[name="_csrf"]').value
            }
        })
            .then(response => {
                console.log('Response received:', response);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

    document.getElementById('addToCartButton').addEventListener('click', addToCart);
    document.getElementById('sizeSelector').addEventListener('change', updateSelectedProductInfo);
    document.getElementById('colorSelector').addEventListener('change', () => {
        updateSelectedProductInfo(); changePictures();
    });
});