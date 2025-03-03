const panels = document.querySelectorAll('.panel');

function initializePanels() {
    //save last active map
    const activeIndex = parseInt(localStorage.getItem('activeItem'));
    if(activeIndex){
        panels[activeIndex].classList.add('active');
        panels[activeIndex].setAttribute('aria-expanded', 'true');
    }else{
        panels.item(0).classList.add('active');
        panels.item(0).setAttribute('aria-expanded', 'true');
    }
    panels.forEach(addListener);
}
initializePanels();

function addListener(panel, index){
    // add Event Listener
    panel.addEventListener(('click'), () => {
            expandingCards(panel, index);
    })   
    panel.addEventListener('keydown', (event) => {
        if (event.key === 'Enter' || event.key === ' ') {
            event.preventDefault(); // remove scroll 
            expandingCards(panel, index);
        }
    });
}


//Remove all active classes
function removeActiveClass(){
    panels.forEach((panel) => {
        panel.classList.remove('active');
        panel.setAttribute('aria-expanded', 'false');
    })
}

//add activ class and close active class
function expandingCards(panel, index){
    //if open -> close
    if(panel.classList.contains('active')){
        panel.classList.remove('active');
        panel.setAttribute('aria-expanded', 'false');
    }else{
        removeActiveClass();
        //add activ to clicked class
        panel.classList.add('active');
        localStorage.setItem('activeItem', index);
        panel.setAttribute('aria-expanded', 'true');
        console.log("index: " + index);
    }
}