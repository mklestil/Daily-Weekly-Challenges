const panels = document.querySelectorAll('.panel');

panels.forEach((panel) => {
    panel.addEventListener('click', () => {
        expandingCards(panel);    
    })
})

function removeActiveClass(){
    panels.forEach((panel) => {
        panel.classList.remove('active');
    })
}

function expandingCards(panel){
    //if open -> close
    if(panel.classList.contains("active")){
        panel.classList.remove('active');
    }else{
        removeActiveClass();
        //add activ to clicked class
        panel.classList.add('active');
    }
}