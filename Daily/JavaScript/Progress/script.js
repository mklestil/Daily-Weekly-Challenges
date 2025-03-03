const btnNext = document.getElementById("next");
const btnPrev = document.getElementById("prev");
let progress = document.getElementById("progress-active");
let circles = document.querySelectorAll(".circle");
const btnSubmit = document.getElementById("selection-form");
const select = document.getElementById("values");
const progressContainer = document.getElementById("progress-container");

let activeValue = 1;


btnNext.addEventListener("click", () => {
    activeValue++;

    //check length
    if(activeValue > circles.length){
        activeValue = circles.length;
    }
    console.log(activeValue);
    updateUI();
})

btnPrev.addEventListener("click", () => {
    activeValue--;

    //check length
    if(activeValue === 1){
        activeValue = 1;
    }
    console.log(activeValue);
    updateUI();
})

btnSubmit.addEventListener("submit", () => {
    event.preventDefault();

    //number of selected circles
    let numberOfCircles = parseInt(select.value, 10);

    //delet circles
    progressContainer.innerHTML = `
    <div class="progress" id="progress"></div>
    <div class="progress progress-active" id="progress-active"></div>`;
    //create circles
    for(let i = 1; i <= numberOfCircles; i++){
        //create circle
        const circle = document.createElement('div');
        circle.classList.add('circle');
        if (i === 1) {
            circle.classList.add('active'); // first circle active
        }
        circle.textContent = i;
        //add circle to div
        progressContainer.appendChild(circle);
    };

    //reset activeValue
    activeValue = 1;
})

function updateUI(){
    //update circles and progress
    circles = document.querySelectorAll(".circle");
    progress = document.getElementById("progress-active");

    circles.forEach((circle, indx) => {
        if(indx < activeValue){
            circle.classList.add("active");
        } else {
            circle.classList.remove("active");
        }
        //all actives
        const actives = document.querySelectorAll(".active");
        console.log("actives " + actives.length)
        //update width, start with 0, in %
        progress.style.width = ((actives.length - 1) / (circles.length - 1) * 100) + '%';
        
        //buttons
        if(activeValue === 1){
            btnPrev.disabled = true;
        }else if(activeValue === circles.length){
            btnNext.disabled = true;
        }else{
            btnNext.disabled = false;
            btnPrev.disabled = false;
        }
    })

}