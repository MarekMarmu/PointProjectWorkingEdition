const slider = document.querySelector('.slider');
const prevButton = document.getElementById('prev');
const nextButton = document.getElementById('next');
const sliderItems = document.querySelectorAll('.slider-item');
const itemWidth = sliderItems[0].offsetWidth + parseInt(getComputedStyle(sliderItems[0]).marginRight);

let currentPosition = 0;

nextButton.addEventListener('click', () => {
    if (currentPosition > -(sliderItems.length - 5) * itemWidth) {
        currentPosition -= itemWidth;
        slider.style.transform = `translateX(${currentPosition}px)`;
    }
});

prevButton.addEventListener('click', () => {
    if (currentPosition < 0) {
        currentPosition += itemWidth;
        slider.style.transform = `translateX(${currentPosition}px)`;
    }
});