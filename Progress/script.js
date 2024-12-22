const btnNext = document.getElementById("next");
const btnPrev = document.getElementById("prev");
const progress = document.getElementById("progress-active");
const circles = document.querySelectorAll(".circle");

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

function updateUI(){
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
        
    })

}