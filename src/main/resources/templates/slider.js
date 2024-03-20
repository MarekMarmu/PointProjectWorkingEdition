let images = ["images/image1.jpg", "images/image2.jpg"];
let currentImageIndex = 0;

const slider = document.getElementById('slider');
const sliderLeft = document.getElementById('sliderLeft');
const sliderRight = document.getElementById('sliderRight');

sliderLeft.addEventListener('click', (e) => {
 currentImageIndex = (currentImageIndex - 1) % images.length;
 slider.src = images[currentImageIndex];
 console.log(currentImageIndex);
});

sliderRight.addEventListener('click', (e) => {
 currentImageIndex = (currentImageIndex + 1) % images.length;
 slider.src = images[currentImageIndex];
 console.log(currentImageIndex);
});