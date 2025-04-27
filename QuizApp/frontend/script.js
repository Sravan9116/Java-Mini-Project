document.getElementById("quiz-form").addEventListener("submit", function(e) {
  e.preventDefault();

  const formData = new FormData(this);
  fetch("http://localhost:8080/QuizApp/quiz", {
    method: "POST",
    body: new URLSearchParams(formData)
  })
  .then(response => response.text())
  .then(result => {
    document.getElementById("result").innerText = result;
  })
  .catch(error => {
    console.error("Error:", error);
    document.getElementById("result").innerText = "Something went wrong.";
  });
});
