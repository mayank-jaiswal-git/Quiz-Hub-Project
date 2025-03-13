let email_check = /^[A-Za-z0-9_.]{6,}@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}$/;
let email_error = document.querySelector("#email_error");
let top_message = document.querySelector("#top-message");
let otp_input_box = document.querySelector("#input-box-otp");
let send_otp_btn = document.querySelector("#sendotpbtn");
let error_message = document.querySelector("#error_message");
let timerDisplay = document.getElementById("timer");
let resendBtn = document.getElementById("resend_OTP");
let validOTP = 0;

top_message.classList.add("message_hide");
otp_input_box.classList.add("input-box-hide");
send_otp_btn.classList.remove("send-otp-btn-hide");

function validateEmail() {
  let email = document.querySelector("#email").value.trim();
  
  if (email_check.test(email)) {
    email_error.classList.add("email_error_hide");
    top_message.classList.remove("message_hide");
    top_message.innerText = "Verifying Email Address...";
    verifyUser(email);
  } else {
    email_error.classList.remove("email_error_hide");
    email_error.innerText = "***Invalid Email Address***";
  }
}


async function verifyUser(userEmail){
  console.log("Verifying User...");
  try {
    const response = await fetch("http://localhost:8080/auth/check", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email: userEmail }),
    });

    const data = await response.json();
    
    if (data.status) {
      email_error.classList.add("email_error_hide");
      send_otp_btn.classList.add("send-otp-btn-hide");
      otp_input_box.classList.remove("input-box-hide");
      top_message.classList.remove("message_hide");
      top_message.innerText = "OTP Send to Your Registered Email Address";
      error_message.classList.add("error_hide");
      getOTP(userEmail);
      updateTimer();
    } else {
      email_error.classList.remove("email_error_hide");
      email_error.innerText = data.message;
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred while processing your request.");
  }
}




async function getOTP(userEmail) {
  console.log("Fetching OTP...");
  let isVerified = "verified";
  try {
    const response = await fetch("http://localhost:8080/auth/forgot-password", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email: userEmail, status : isVerified }),
    });

    const data = await response.json();
    validOTP = data.otp;

    if (data.status) {
      error_message.classList.add("error_hide");
      localStorage.setItem("EMAIL", userEmail);
      document.querySelector("#verify-OTP-btn").addEventListener("click", checkOTP, { once: true });
    } else {
      email_error.classList.remove("email_error_hide");
      email_error.innerText = data.message;
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred while processing your request.");
  }
}

let timeLeft = 180; // 3 minutes in seconds


function updateTimer() {
    let minutes = Math.floor(timeLeft / 60);
    let seconds = timeLeft % 60;
    seconds = seconds < 10 ? "0" + seconds : seconds;
    timerDisplay.innerHTML = `${minutes}:${seconds}`;
  
    if (timeLeft > 0) {
      timeLeft--;
      setTimeout(updateTimer, 1000);
    } else {
      timerDisplay.innerHTML = "00:00";
      resendBtn.classList.remove("resend-otp-hide"); // Show Resend OTP button
    }
  }

resendBtn.classList.add("resend-otp-hide");

document.querySelector("#resend_OTP").addEventListener("click", () => {
  alert("New OTP sent!");
  timeLeft = 180;
  resendBtn.classList.add("resend-otp-hide");
  updateTimer();
  getOTP(document.querySelector("#email").value.trim());
});

function checkOTP() {
  let userOTP = document.querySelector("#input_otp").value.trim();
  if (validOTP == userOTP) {
    error_message.classList.add("error_hide");
    window.location.href = "ResetPswdQuiz.html";
  } else {
    error_message.classList.remove("error_hide");
    error_message.innerText = "***Invalid OTP Entered***";
    document.querySelector("#verify-OTP-btn").addEventListener("click", checkOTP, { once: true });
  }
}
