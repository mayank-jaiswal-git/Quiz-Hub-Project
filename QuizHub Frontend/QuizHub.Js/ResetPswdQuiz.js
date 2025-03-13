let userEmail = localStorage.getItem("EMAIL");
console.log(userEmail);


document.querySelector("#reset-btn").addEventListener("click", function(event) {
   event.preventDefault();

   let New_Password = document.querySelector("#newpassword").value;
   let Confirm_Password = document.querySelector("#confpassword").value;
   let pswd_check = /^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*_]{8,16}$/;
   let pswd_error = document.querySelector("#pswd_error");
   let conpswd_error = document.querySelector("#conpswd_error");
   if (pswd_check.test(New_Password)) {
    pswd_error.classList.add("pswd_hide");
    if (Confirm_Password == New_Password) {
        conpswd_error.classList.add("conpswd_hide");
        resetPassword(New_Password);
      } else {
        conpswd_error.classList.remove("conpswd_hide");
      }
    
  } else {
    pswd_error.classList.remove("pswd_hide");
  }
});




async function resetPassword(Password){
  console.log("Password" + Password);

  try {
    const response = await fetch("http://localhost:8080/auth/reset-password", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email: userEmail, password : Password }),
    });

    const data = await response.text();
    console.log(data);
    if (data) {
      window.location.href = "LoginQuiz.html";
    } else {
        console.error("Error:", error);
        alert("Password Not Change Due to Some Error. Please Try Again..");
        window.location.href = "LoginQuiz.html";
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred while processing your request.");
  }
}