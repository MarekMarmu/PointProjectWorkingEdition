let images = ["images/image1.jpg", "images/image2.jpg"];
let currentImageIndex = 0;

const slider: HTMLElement  = document.getElementById('slider');
const sliderLeft: HTMLElement  = document.getElementById('sliderLeft');
const sliderRight: HTMLElement  = document.getElementById('sliderRight');

sliderLeft.addEventListener('click', (e: Event) => {
    currentImageIndex = (currentImageIndex - 1 + images.length) % images.length;
    slider.setAttribute('src', images[currentImageIndex]);
    console.log(currentImageIndex);
});

sliderRight.addEventListener('click', (e: Event) => {
    currentImageIndex = (currentImageIndex + 1) % images.length;
    slider.setAttribute('src', images[currentImageIndex]);
    console.log(currentImageIndex);
});