let name_error = document.querySelector("#name_error");
let username_error = document.querySelector("#username_error");
let email_error = document.querySelector("#email_error");
let phno_error = document.querySelector("#phno_error");
let pswd_error = document.querySelector("#pswd_error");
let conpswd_error = document.querySelector("#conpswd_error");

let name_check = /^[A-Za-z .]{3,}$/;

let username_check = /^[A-Za-z0-9 ._]{3,}$/;

let pswd_check = /^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*_]{8,16}$/;

let email_check = /^[A-Za-z0-9_.]{6,}@[a-z]{3,}[.]{1}[a-z.]{2,6}$/;

let phno_check = /^[6-9]{1}[0-9]{9}$/;

document.querySelector("#form").addEventListener("submit", async function (event) {
  event.preventDefault(); // Prevent default form submission
  let name = document.querySelector("#name").value;
  let username = document.querySelector("#username").value;
  let email = document.querySelector("#email").value;
  let phno = document.querySelector("#phno").value;
  let pswd = document.querySelector("#pswd").value;
  let conpswd = document.querySelector("#conpswd").value;
  let gender_1 = document.querySelector("#dot-1");
  let gender_2 = document.querySelector("#dot-2");
  let gender_3 = document.querySelector("#dot-3");
 
  let status = false;
  if (name_check.test(name)) {
    name_error.classList.add("name_hide");
    status = true;
  } else {
    name_error.classList.remove("name_hide");
    return status;
  }

  if (username_check.test(username)) {
    username_error.classList.add("username_hide");
    status = true;
  } else {
    username_error.classList.remove("username_hide");
    return status;
  }

  if (email_check.test(email)) {
    email_error.classList.add("email_hide");
    status = true;
  } else {
    email_error.classList.remove("email_hide");
    return status;
  }

  if (phno_check.test(phno)) {
    phno_error.classList.add("phno_hide");
    status = true;
  } else {
    phno_error.classList.remove("phno_hide");
    return status;
  }

  if (pswd_check.test(pswd)) {
    pswd_error.classList.add("pswd_hide");
    if (conpswd == pswd) {
      conpswd_error.classList.add("conpswd_hide");
      status = true;
    } else {
      conpswd_error.classList.remove("conpswd_hide");
      return status;
    }
  } else {
    pswd_error.classList.remove("pswd_hide");
    return status;
  }


  if (gender_1.checked || gender_2.checked || gender_3.checked) {
    gender_error.classList.add("gender_hide");
    status = true;
  } else {
    gender_error.classList.remove("gender_hide");
  }
  
  if(status){
    registerUser();
  }else{
    return status;
  }

});

async function registerUser() {
   

    let fullName = document.getElementById("name").value;
    let userName = document.getElementById("username").value;
    let email = document.getElementById("email").value;
    let phno = document.getElementById("phno").value;
    let pswd = document.getElementById("pswd").value;

    const genderRadios = document.getElementsByName("gender");
    let selectedGender = null;

    // Loop through radio buttons
    for (const gender of genderRadios) {
      if (gender.checked) {
        selectedGender = gender.value;
        break;
      }
    }

    console.log(fullName);
    console.log(userName);
    console.log(email);
    console.log(pswd);
    console.log(phno);
    console.log(selectedGender);

    try {
      const response = await fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          fullName: fullName,
          userName: userName,
          email: email,
          password: pswd,
          contactNo: phno,
          gender: selectedGender,
        }),
      });

      if (!response.ok) {
        throw new Error("Registration failed");
      }

      const result = await response.text();

      // Redirect to login page after successful registration
      window.location.href = "LoginQuiz.html";
    } catch (error) {
      console.error("Error:", error);
      alert("An error occurred while registering. Please try again.");
    }
  }
