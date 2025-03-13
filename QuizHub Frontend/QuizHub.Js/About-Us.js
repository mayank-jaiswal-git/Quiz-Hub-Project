document.addEventListener("DOMContentLoaded", () => {
    const hamburger = document.querySelector(".hamburger")
    const navLinks = document.querySelector(".nav-links")
  
    hamburger.addEventListener("click", () => {
      navLinks.classList.toggle("active")
    })
  })
  
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