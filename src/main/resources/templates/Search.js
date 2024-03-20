let searchBar = document.getElementById("search");
let searchOptions = document.getElementById("searchOptions");

searchBar.addEventListener('input', () => {
    fetch(`/search?query=${encodeURIComponent(searchBar.value)}`, {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {

            searchOptions.innerHTML = "";
            data.forEach(product => {
                let productLink = document.createElement('a');
                productLink.target = "blank"
                productLink.text = product.name;
                productLink.href = `/product/${product.name}`;
                let productImage = document.createElement('img');
                productImage.src = `/images/${product.mainImage.id}`;
                productImage.width = 100;
                productImage.height = 100;
                productLink.appendChild(productImage);
                searchOptions.appendChild(productLink);

            });
        })
        .catch(error => {
            console.error('Chyba:', error);
        });
});