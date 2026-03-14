const userId = 1;

let profileData = {};

window.onload = loadProfile;

function loadProfile(){

fetch(`/api/users/profile/${userId}`)
.then(res=>res.json())
.then(data=>{

profileData = data;

document.getElementById("username").innerText = data.name;
document.getElementById("nameText").innerText = data.name;
document.getElementById("bioText").innerText = data.bio;
document.getElementById("avatarPreview").src = data.avatarUrl;
document.getElementById("miniAvatar").src = data.avatarUrl;

});

}

function editName(){

let value = prompt("Enter new name:", profileData.name);

if(value){
profileData.name = value;
document.getElementById("nameText").innerText = value;
document.getElementById("username").innerText = value;
}

}

function editBio(){

let value = prompt("Enter new bio:", profileData.bio);

if(value){
profileData.bio = value;
document.getElementById("bioText").innerText = value;
}

}

function uploadAvatar(){

document.getElementById("avatarInput").click();

}

document.getElementById("avatarInput").addEventListener("change", function(){

const file = this.files[0];

if(!file) return;

const reader = new FileReader();

reader.onload = function(e){

profileData.avatarUrl = e.target.result;

document.getElementById("avatarPreview").src = e.target.result;
document.getElementById("miniAvatar").src = e.target.result;

};

reader.readAsDataURL(file);

});

function saveProfile(){

fetch(`/api/users/profile/${userId}`,{

method:"PUT",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify(profileData)

})
.then(()=>{

alert("Profile updated");

location.reload();

});

}