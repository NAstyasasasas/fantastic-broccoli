let currentSlide = 0;

function nextSlide() {
    currentSlide = (currentSlide + 1) % 3;
    updateSlider();
}

function prevSlide() {
    currentSlide = (currentSlide - 1 + 3) % 3;
    updateSlider();
}

function updateSlider() {
    const slides = document.querySelector('.slides');
    if (slides) {
        slides.style.transform = `translateX(-${currentSlide * 100}%)`;
    }
}

function validateForm() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const message = document.getElementById('message').value;

    if (name && email.includes('@') && message) {
        alert('Отправлено!');
    } else {
        alert('Где-то вышла ошибочка');
    }
}

function toggleTheme() {
    document.body.classList.toggle('light-theme');
}


function loadNews() {
    const news = [
        "Новость 1: Открылся новый приют для котиков",
        "Новость 2: Кот установил рекорд по прыжкам",
        "Новость 3: Вышла книга о кошках"
    ];
    const container = document.getElementById('newsContainer');
    container.innerHTML = '';

    news.forEach(item => {
        const div = document.createElement('div');
        div.className = 'news-item';
        div.textContent = item;
        container.appendChild(div);
    });
}
function toggleMenu() {
            document.getElementById('dropdownMenu').classList.toggle('show');
}
document.querySelectorAll('.dropdown').forEach(dropdown => {
    dropdown.addEventListener('click', function() {
        this.querySelector('.dropdown-content').classList.toggle('show');
    });
});