//Variable

let name;
let life;
let money;
let awake=true;

let b1=document.querySelector("#b1");
let b2=document.querySelector("#b2");
let b3=document.querySelector("#b3");
let b4=document.querySelector("#b4");
let b5=document.querySelector("#b5");
let b6=document.querySelector("#b6");
let b7=document.querySelector("#b7");

let k=document.querySelector("#k");

let actionbox=document.querySelector("#actionbox");

let newP1 = document.createElement('li');
let newP2 = document.createElement('li');
let newP3 = document.createElement('li');
let stat=document.querySelector("#status");
stat.removeChild(stat.firstChild);

window.addEventListener('load', function() {
        go();
        displayStatus(life,money,awake);
    }
  );

//Etape 1

function init(n,l,m){
    name=n;
    life=l;
    money=m;
};

function go(){
	let ne = prompt(" Donner un nom"," ");
    let le = prompt(" Donner une vie"," ");
    let me = prompt(" Donner de l'argent"," ");
    init(ne,le,me);
    b2.addEventListener('click', run);
    b3.addEventListener('click', fight);
    b4.addEventListener('click', sleep);
    b5.addEventListener('click', eat);
    b6.addEventListener('click', showme);
    b7.addEventListener('click', work);
    setInterval(hasard, temps);
    b1.addEventListener('click', newLife);
    k.addEventListener('click', kill);
};

//Etape 2


function log(message){
	let m=actionbox.firstChild;
	let newP = document.createElement('p');
	newP.textContent = message;
    actionbox.insertBefore(newP,m);
};

function displayStatus(life, money, awake){
    for(let i=0;i<3;i++){
        stat.removeChild(stat.firstChild);
    }
    newP3.textContent = awake;
    stat.insertBefore(newP3,stat.firstChild)
    newP2.textContent = "Money: "+money;
    stat.insertBefore(newP2,stat.firstChild)
    newP1.textContent = "Life: "+life;
    stat.insertBefore(newP1,stat.firstChild)
};

function showme(){
    let phrase="Le nom : "+name +", la vie : "+life+", l'argent : "+money+", Est-il reveillé : "+awake; 
    log(phrase);
};

//Etape 3

function run(){
    let phrase;
    if((life>=1)&&(awake==true)){
        life--;
        if(life!=0){
            phrase=("Le monstre fais du naruto run il perd un pv, il lui reste donc "+life+" de vie");
        }else{
            phrase=("Le monstre cours mais se foule la cheville et meurt dans de terribles souffrances");
        }
    } else {
        if(life<=0){
            phrase=("Le monstre ne peut pas courir car il est mort et les morts ca ne court pas!");
        }else{
            phrase=("Le monstre est en train de dormir laisser le tranquille!");
        }
    }
    log(phrase);
displayStatus(life, money, awake)
}


function fight(){
	let phrase;
    if((life>=1)&&(awake==true)){
        life-=3;
        if(life>0){
            phrase=("Le monstre se prend pour ce con de Rock Lee il perd trois pv, il lui reste donc "+life+" de vie");
        }else{
            phrase=("Le monstre se bat mais il etait face a Gaara, il meurt");
        }
    } else {
        if(life<=0){
            phrase=("Le monstre ne peut pas se battre car il est mort et les morts ca ne se bat pas!");
        }else{
            phrase=("Le monstre est en train de dormir laisser le tranquille!");
        }
    }
    log(phrase);
displayStatus(life, money, awake)
};

function eat(){
	let phrase;
    if((money>=3)&&(awake==true)&&(life>0)){
        money-=3;
        life++;
        life++;
        if(money!=0){
            phrase=("Le monstre se prend pour ce gros porc de Choji il gagne deux pv et perd trois d'argents, il lui reste donc "+life+" de vie et "+money+" d'argent");
        }else{
            phrase=("Le monstre mange trop, il n'as plus de fric");
        }
    } else {
        if(money<3){
            phrase=("Le monstre ne peut pas manger car il est trop gros et ne peu plus se deplacer!");
        }
        else if(life<=0){
            phrase=("Le monstre ne peut que manger de la terre car il est mort!");
        }else{
            phrase=("Le monstre est en train de dormir laisser le tranquille!");
        }
    }
    log(phrase);
displayStatus(life, money, awake)
};

function work(){
	let phrase;
    if((life>=1)&&(awake==true)){
        life--;
        money++;
        money++;
        if(life!=0){
            phrase=("Le monstre se prend pour ce surdoué de Shikamaru il perd un pv et gagne deux d'argents, il lui reste donc "+life+" de vie et "+money+" d'argent");
        }else{
            phrase=("Le monstre joue au Shôgi, il perd et meurt");
        }
    } else {
        if(life<=0){
            phrase=("Le monstre ne peut pas travailler car il est mort et les morts ca ne travail pas!");
        }else{
            phrase=("Le monstre est en train de dormir laisser le tranquille!");
        }
    }
    log(phrase);
    displayStatus(life, money, awake)
};

function sleep(){
	if((life>=1)&&(awake==true)){
	    awake=false;
	    displayStatus(life,money,awake);
	    log("Le monstre se prend pour le Demon à 10 queues et tombe dans un sommeil profond");
	    setTimeout(function(){ log("Le monstre se reveille et gagne 1pv");
	                            life++;
	                            awake=true;}, 7000);
	}else {
        if(life<=0){
            phrase=("Le monstre dors dans sa tombe");
        }else{
            phrase=("Le monstre dors deja, il ne peut pas redormir!");
        }
    }
    log(phrase);
    displayStatus(life,money,awake);
};

//Etape 4

let temps=12000;

function hasard(){
    let rand=Math.floor(Math.random() * 5);
    if(rand==0){
        run();
    }
    if(rand==1){
        fight();
    }
    if(rand==2){
        work();
    }
    if(rand==3){
        sleep();
    }
    if(rand==4){
        eat();
    }
}

function kill(){
	let phrase;
    if(life>0){
    	life=0;
           phrase=("Le monstre Meurt tel Neji");
    } else {
        phrase=("Aucun monstre n'est vivant.. ils sont tous morts");
        }
    log(phrase);
    displayStatus(life, money, awake);
};

function newLife(){
	let phrase;
    if(life<=0){
           phrase=("Le monstre ressuscite tel Madara");
           go();
    } else {
        phrase=("Un monstre est deja vivant! C'est deja assez compliqué de s'en occuper d'un");
        }
    log(phrase);
    displayStatus(life, money, awake);
};

function displayStatus(life,money,awake){
    for(let i=0;i<3;i++){
        stat.removeChild(stat.firstChild);
    }
    if(awake){
        newP3.textContent = "Awake";
    }else{
        newP3.textContent = "Asleep";
    }
    stat.insertBefore(newP3,stat.firstChild)
    newP2.textContent = "Money: "+money;
    stat.insertBefore(newP2,stat.firstChild)
    newP1.textContent = "Life: "+life;
    stat.insertBefore(newP1,stat.firstChild)
    let interface=document.querySelector("#monster");
    if(life>20){
        interface.style.backgroundColor='green';
    }else if((life<=20)&&(life>13)){
        interface.style.backgroundColor='blue';
    }else if((life<=13)&&(life>5)){
        interface.style.backgroundColor='orange';
    }else{
        interface.style.backgroundColor='red';
    }
    let bordure=money/4+"px";
    interface.style.borderStyle="solid";
    if(money>=60){
        interface.style.borderColor="gold";
    }else if((money<60)&&(money>=30)){
        interface.style.borderColor="silver";
    }else{
        interface.style.borderColor="brown";
    }
    interface.style.borderWidth=bordure;
    interface.style.height=life+"px";
    if(life<=0){
    	b2.style.backgroundColor='grey';
    	b3.style.backgroundColor='grey';
    	b4.style.backgroundColor='grey';
    	b5.style.backgroundColor='grey';
    	b6.style.backgroundColor='grey';
    	b7.style.backgroundColor='grey';
    	k.style.backgroundColor='grey';
    }else{
    	b2.style.backgroundColor='deepskyblue';
    	b3.style.backgroundColor='deepskyblue';
    	b4.style.backgroundColor='deepskyblue';
    	b5.style.backgroundColor='deepskyblue';
    	b6.style.backgroundColor='deepskyblue';
    	b7.style.backgroundColor='deepskyblue';
    	k.style.backgroundColor='deepskyblue';
    }
    if(money<=2){
    	b5.style.backgroundColor='grey';
    }else{
    	b5.style.backgroundColor='deepskyblue';
    }
}