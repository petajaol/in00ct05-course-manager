getCourses();

const courseForm = document.getElementById("courseform");
courseForm.addEventListener("submit", handleAddCourse);

function handleAddCourse() {
  const newCourse = {
    name: document.getElementById("name").value,
    teacher: document.getElementById("teacher").value,
  };
  postCourse(newCourse);
}

async function getCourses() {
  const courses = await fetch("http://localhost:8080/courses");
  const json = await courses.json();
  showCourses(json);
}

async function postCourse(newCourse) {
  await fetch("http://localhost:8080/courses", {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(newCourse),
  });
}

function showCourses(json) {
  document.getElementById("courses").innerHTML = "";
  const coursesTable = document.getElementById("courses");
  json.map((course) => {
    const row = coursesTable.insertRow();
    for (const prop in course) {
      row.insertCell().innerHTML = `${course[prop]}`;
    }
  });
}
