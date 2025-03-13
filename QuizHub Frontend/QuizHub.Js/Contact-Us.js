document.addEventListener("DOMContentLoaded", () => {
    const hamburger = document.querySelector(".hamburger")
    const navLinks = document.querySelector(".nav-links")
  
    hamburger.addEventListener("click", () => {
      navLinks.classList.toggle("active")
    });
  });

  let logOutButton = document.querySelector("#logout");
  let loginButton = document.querySelector("#login");
  
  if (localStorage.getItem("token") == null) {
    loginButton.classList.remove("login_hide");
    logOutButton.classList.add("logout_hide");
  } else {
    loginButton.classList.add("login_hide");
    logOutButton.classList.remove("logout_hide");
  }
  
// Logout functionality
document.querySelector("#logout").addEventListener("click", function () {
  // Clear login state
  localStorage.removeItem("token");
  // Redirect to login
  window.location.href = "Home.html";
});
    
    const contactForm = document.getElementById("contactForm");
    let conatct_form = document.querySelector("#contact-form");
    conatct_form.classList.remove("contact-hide");
    contactForm.addEventListener("submit", async (e) => {
      e.preventDefault()

      let fullNameValue = document.querySelector("#fullName").value;
      let emailValue = document.querySelector("#email").value;
      let descriptionValue = document.querySelector("#description").value;
      
      try {
        const response = await fetch("http://localhost:8080/contact/save", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            fullName: fullNameValue,
            email: emailValue,
            description : descriptionValue
          }),
        });
  
  
        const result = await response.text();

        let conatct_form = document.querySelector("#contact-form");
        let response_form = document.querySelector("#reponse");
        if(result){
          conatct_form.classList.add("contact-hide");
          response_form.classList.remove("response-hide");
          setTimeout(() => {
            contactForm.reset()
            response_form.classList.add("response-hide");
            conatct_form.classList.remove("contact-hide");
          }, 1000); 
        }
        else{
          console.error("Error:", error);
          alert("An error occurred while Contacting. Please try again.");
        }
        // Redirect to login page after successful registration
      } catch (error) {
        console.error("Error:", error);
        alert("An error occurred while Contacting. Please try again.");
      }
      
    });
  

  