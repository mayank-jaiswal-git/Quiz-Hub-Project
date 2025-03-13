console.log(localStorage.getItem("token"))
document.addEventListener("DOMContentLoaded", () => {
  const hamburger = document.querySelector(".hamburger");
  const navLinks = document.querySelector(".nav-links");

  hamburger.addEventListener("click", () => {
    navLinks.classList.toggle("active");
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



async function startQuiz(quizType) {
  let login_token = localStorage.getItem("token");
  
  try {
    const response = await fetch("http://localhost:8080/auth/check-token", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token: login_token }), // Send email & password
    });
    const data = await response.text();
    console.log(data);
   
    if (data) {
      alert(
        `Starting ${quizType.charAt(0).toUpperCase() + quizType.slice(1)} Quiz!`
      );
      localStorage.setItem("QuizType", quizType);
      // Redirecting to the corresponding quiz page based on the selected type
      window.location.href = `${quizType}Quiz.html`; // Assumes pages are named quiz-java.html, quiz-python.html, etc.a
    } else {
      window.location.href = "LoginQuiz.html";
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred. Please try again later.");
  }
 
}

let JavaNotes = document.querySelector("#java-notes");
let CompilerNotes = document.querySelector("#compiler-notes");
let springNotes = document.querySelector("#spring-notes");
let ReactNotes = document.querySelector("#react-notes");
let developmentNotes = document.querySelector("#development-notes");
let pythonNotes = document.querySelector("#python-notes");

JavaNotes.addEventListener("click",async() => {
  let login_token = localStorage.getItem("token");
  try {
    const response = await fetch("http://localhost:8080/auth/check-token", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token: login_token }), // Send email & password
    });
    const data = await response.text();
    console.log(data);
   
    if (data) {
      window.location.href = `../QuizHub-Notes/Java Notes.pdf`;
    } else {
      window.location.href = "LoginQuiz.html";
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred. Please try again later.");
  }

});

CompilerNotes.addEventListener("click",async() => {
  let login_token = localStorage.getItem("token");
  try {
    const response = await fetch("http://localhost:8080/auth/check-token", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token: login_token }), // Send email & password
    });
    const data = await response.text();
    console.log(data);
   
    if (data) {
      window.location.href = `../QuizHub-Notes/COMPILER DESIGN NOTES.pdf`;
    } else {
      window.location.href = "LoginQuiz.html";
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred. Please try again later.");
  }

});

springNotes.addEventListener("click",async() => {
  let login_token = localStorage.getItem("token");
  try {
    const response = await fetch("http://localhost:8080/auth/check-token", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token: login_token }), // Send email & password
    });
    const data = await response.text();
    console.log(data);
   
    if (data) {
      window.location.href = `../QuizHub-Notes/Spring Boot Notes.pdf`;
    } else {
      window.location.href = "LoginQuiz.html";
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred. Please try again later.");
  }

});

ReactNotes.addEventListener("click",async() => {
  let login_token = localStorage.getItem("token");
  try {
    const response = await fetch("http://localhost:8080/auth/check-token", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token: login_token }), // Send email & password
    });
    const data = await response.text();
    console.log(data);
   
    if (data) {
      window.location.href = `../QuizHub-Notes/React Notes.pdf`;
    } else {
      window.location.href = "LoginQuiz.html";
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred. Please try again later.");
  }

});

developmentNotes.addEventListener("click",async() => {
  let login_token = localStorage.getItem("token");
  try {
    const response = await fetch("http://localhost:8080/auth/check-token", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token: login_token }), // Send email & password
    });
    const data = await response.text();
    console.log(data);
   
    if (data) {
      window.location.href = `../QuizHub-Notes/DevOps-Notes.pdf`;
    } else {
      window.location.href = "LoginQuiz.html";
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred. Please try again later.");
  }

});

pythonNotes.addEventListener("click",async() => {
  let login_token = localStorage.getItem("token");
  try {
    const response = await fetch("http://localhost:8080/auth/check-token", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ token: login_token }), // Send email & password
    });
    const data = await response.text();
    console.log(data);
   
    if (data) {
      window.location.href = `../QuizHub-Notes/python Notes.pdf`;
    } else {
      window.location.href = "LoginQuiz.html";
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred. Please try again later.");
  }

});