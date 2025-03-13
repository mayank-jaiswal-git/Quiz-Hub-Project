let currentQuestionIndex = 0;
let questions = [];
let correctAnswers = 0; // Variable to track the number of correct answers
let totalQuestions = 0; // This will be set dynamically based on the API response
let timerInterval; // Variable to store the timer interval
let totalTime = 20 * 60; // Total quiz time in seconds (30 minutes)
let batchSize = 10; // Number of questions to display at a time

const java_Api = "http://localhost:8080/java/JavaQuestions";
const Python_Api = "http://localhost:8080/python/pythonQuestions";
const js_Api = "http://localhost:8080/javascript/javascriptQuestions";
const net_Api = "http://localhost:8080/net/netQuestions";

let nextBatch_btn = document.querySelector("#next-batch");
let result_btn = document.querySelector("#result-button");

nextBatch_btn.classList.add("next-batch-hide");
result_btn.classList.add("result-button-hide");

let quizType = localStorage.getItem("QuizType");
console.log(quizType);
// Set quiz header and fetch questions
if (quizType === "Java") {
  window.onload = fetchQuestions(java_Api);
} else if (quizType === "Python") {
  window.onload = fetchQuestions(Python_Api);
} else if (quizType === "JavaScript") {
  window.onload = fetchQuestions(js_Api);
} else if (quizType === "Net") {
  window.onload = fetchQuestions(net_Api);
}

// Fetch questions from the API
async function fetchQuestions(data_Api) {
  try {
    const response = await fetch(data_Api);
    if (!response.ok) {
      throw new Error("Network response was not ok");
    }
    questions = await response.json();// Assume API returns an array of question objects
    totalQuestions = questions.length/2; // Set totalQuestions based on fetched data
    document.getElementById("total-questions").textContent = totalQuestions; // Update the total questions in the HTML
    displayQuestion(questions); // Display questions
    startTimer(); // Start the total quiz timer
  } catch (error) {
    console.error("Error fetching questions:", error);
    document.getElementById("question-text").textContent =
      "Failed to load questions. Please try again.";
  }
}

// Modify the displayQuestion function to pass the button reference
function displayQuestion() {
  if (questions.length === 0) return;

  const questionText = document.getElementById("question-text");
  const optionsContainer = document.getElementById("options-container");
  const currentQuestion = questions[currentQuestionIndex];
  questionText.textContent = currentQuestion.question;
  optionsContainer.innerHTML = "";

  currentQuestion.options.forEach((option) => {
    const button = document.createElement("button");
    button.textContent = option.option_Text;
    button.className = "option";
    button.onclick = () => checkAnswer(option, button); // Pass the button reference
    optionsContainer.appendChild(button);
  });

  document.getElementById("current-question").textContent = currentQuestionIndex + 1;
}


function checkAnswer(selectedOption, button) {
  const currentQuestion = questions[currentQuestionIndex];
  if (selectedOption.option_Text === currentQuestion.correctAnswer) {
    button.style.backgroundColor = "green"; // Set background color to green for correct answer
    correctAnswers++;
  } else {
    button.style.backgroundColor = "red"; // Set background color to red for wrong answer
  }
  
  setTimeout(() => {
    nextQuestion(); // Move to the next question after a short delay
  }, 500);
}

// Load the next question or next batch
function nextQuestion() {
  if (currentQuestionIndex < questions.length - 1) {
    currentQuestionIndex++;
    if (currentQuestionIndex % batchSize === 0) {
      // Reached the end of the current batch
      nextBatch_btn.classList.remove("next-batch-hide");
      result_btn.classList.remove("result-button-hide");
      // alert("Batch completed. Click 'Next Batch' to proceed.");
      return;
      
    }
    displayQuestion();
    updateProgressBar();
  } else {
    // Quiz Completed: Save score and redirect to results page
    submitQuiz();
  }
}

// Show the next batch of questions
function loadNextBatch() {
  if (
    currentQuestionIndex % batchSize === 0 &&
    currentQuestionIndex < questions.length
  ) {
    totalQuestions = questions.length;
    document.getElementById("total-questions").textContent = totalQuestions; 
    displayQuestion();
  } else {
    alert("No more questions in this batch!");
  }
}

// Display the result for the current batch
function displayBatchResult() {
  const startIndex = Math.max(0, currentQuestionIndex - batchSize);
  const batchQuestions = questions.slice(startIndex, currentQuestionIndex);
  const batchCorrectAnswers = batchQuestions.reduce(
    (sum, question) =>
      sum + (question.selectedAnswer === question.correctAnswer ? 1 : 0),
    0
  );

  alert(
    `Batch Result: Are you sure to see the Result of Attemped ${batchQuestions.length} Questions`
  );
}

// Submit quiz
function submitQuiz() {
  clearInterval(timerInterval); // Stop the timer
  localStorage.setItem("quizScore", correctAnswers); // Save the score
  localStorage.setItem("totalQuestions", totalQuestions); // Save total questions
  window.location.href = "ResultQuiz.html"; // Redirect to results page
}

// Total quiz timer function
function startTimer() {
  const timerElement = document.getElementById("timer");
  timerInterval = setInterval(() => {
    if (totalTime > 0) {
      totalTime--;
      const minutes = Math.floor(totalTime / 60);
      const seconds = totalTime % 60;
      timerElement.textContent = `${minutes}:${
        seconds < 10 ? "0" + seconds : seconds
      }`; // Update the timer display
    } else {
      submitQuiz(); // Submit the quiz when the timer runs out
    }
  }, 1000);
}

function updateProgressBar() {
  const progressBar = document.getElementById("progress-bar");
  const progressPercentage = (currentQuestionIndex / totalQuestions) * 100;
  progressBar.style.width = `${progressPercentage}%`;
}

// Get the script tag that loaded this file
const scriptTag = document.currentScript;

// Extract query parameters from the src attribute
const urlParams = new URLSearchParams(new URL(scriptTag.src).search);

// Access the parameters
const username = urlParams.get("file");

// Add event listeners for buttons
document.getElementById("next-batch").onclick = ()=>{ 
  loadNextBatch();
  nextBatch_btn.classList.add("next-batch-hide");
 result_btn.classList.add("result-button-hide");
};
const rsbtn = document.getElementById("result-button");
rsbtn.addEventListener("click", () => {
  displayBatchResult();
  submitQuiz();
});
