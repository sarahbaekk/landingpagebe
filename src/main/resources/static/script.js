document.getElementById('signupForm').addEventListener('submit', function (event) {
  event.preventDefault(); // Prevent actual form submission

  const email = document.getElementById('emailInput').value;
  console.log('Collected email:', email); // For debugging
  localStorage.setItem('userEmail', email); // Optional test

  fetch("http://localhost:8080/signup", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email: email })
  })
      .then(res => res.text())
      .then(message => {
        console.log("Server said:", message);
        alert("Thanks for signing up!");

        // Optional: show thank-you message if you have it
        const thankYouEl = document.getElementById('thankYouMessage');
        if (thankYouEl) thankYouEl.style.display = 'block';

        document.getElementById('signupForm').reset();
      })
      .catch(err => {
        console.error("Error:", err);
        alert("There was an issue. Please try again.");
      });
});
