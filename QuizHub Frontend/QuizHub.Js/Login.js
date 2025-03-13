document.querySelector("#loginform").addEventListener("submit", async function (event) {
    event.preventDefault(); // Prevent default form submission

    const useremail = document.querySelector("#email").value;
    const userpassword = document.querySelector("#password").value;
    let error_message_show = document.querySelector("#error_message");
   
    let error_message = "";
    let error_status = false;
    let token = "";
    if (!useremail || !userpassword) {
      alert("Please fill in both fields.");
      return;
    }

    try {
      const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email: useremail, password: userpassword }), // Send email & password
      }).then(response => response.json()) // Parse JSON
      .then(data => {
          // console.log(data.message); // Access message
          // console.log(data.status); 

        error_message = data.message;
        error_status = data.status; 
        token = data.token;

    })
     
      if (error_status) {
        error_message_show.classList.add("error_hide");
        localStorage.setItem("token",token);
        console.log(error_message);
        window.location.href = "Home.Html"; // Redirect to Home page
      } else {
        console.log(error_message);
        error_message_show.classList.remove("error_hide");
        error_message_show.innerText = error_message;
      }
    } catch (error) {
      console.error("Error:", error);
      alert("An error occurred. Please try again later.");
    }
  });
