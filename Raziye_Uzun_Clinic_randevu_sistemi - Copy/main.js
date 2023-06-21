
const addKundeButton = document.querySelector('.addKundeButton');
const showKundeButton = document.querySelector('.showKundeButton');

const showKunde = document.querySelector('.showKunde');
const addKunde = document.querySelector('.addKunde');


const addTermin = document.querySelector('.addTermin');
const addTerminButton = document.querySelector('.addTerminButton');

const showTermin = document.querySelector('.showTermin');
const showTerminButton = document.querySelector('.showTerminButton');


const showArztButton = document.querySelector('.showArztButton');
const showArzt = document.querySelector('.showArzt');

const showZimmerButton = document.querySelector('.showZimmerButton');
const showZimmer = document.querySelector('.showZimmer');
 
boxList=[addTermin, addKunde, showKunde, showTermin,showArzt,showZimmer ];


function myFunction(item) {
    item.classList.remove('active');
  }

addKundeButton.addEventListener('click', () => {
    boxList.forEach(myFunction);
    addKunde.classList.add('active');
});

showKundeButton.addEventListener('click', () => {
    boxList.forEach(myFunction);
    showKunde.classList.add('active');
});



addTerminButton.addEventListener('click', () => {
  boxList.forEach(myFunction);
  addTermin.classList.add('active');
});


showTerminButton.addEventListener('click', () => {
boxList.forEach(myFunction);
showTermin.classList.add('active');
});


showArztButton.addEventListener('click', () => {
boxList.forEach(myFunction);
showArzt.classList.add('active');
});

showZimmerButton.addEventListener('click', () => {
boxList.forEach(myFunction);
showZimmer.classList.add('active');
});