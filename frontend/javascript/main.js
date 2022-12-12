const BASE_URL = 'http://localhost:8080/';
const form = document.getElementById('task-form');
const taskList = document.getElementById('task-list');
const completedTaskList = document.getElementById('completed-task-list');

function addTask(task) {
    const taskElement = document.createElement('div');
    taskElement.classList.add('task');

    taskElement.innerHTML = `
        <span class="task-name">${task.name}</span>
        <span class="task-due-date">${task.dueDate}</span>
        <span class="task-priority">${task.priority}</span>
        <button class="complete-task-button" data-task-id="${task.id}">Complete</button>
    `;

    taskList.append(taskElement);
}
function addTask(task) {
    const taskElement = document.createElement('div');
    taskElement.classList.add('task');

    const taskNameElement = document.createElement('span');
    taskNameElement.classList.add('task-name');
    taskNameElement.innerText = task.name;

    const taskDueDateElement = document.createElement('span');
    taskDueDateElement.classList.add('task-due-date');
    taskDueDateElement.innerText = task.dueDate;

    const taskPriorityElement = document.createElement('span');
    taskPriorityElement.classList.add('task-priority');
    taskPriorityElement.innerText = task.priority;

    taskElement.appendChild(taskNameElement);
    taskElement.appendChild(taskDueDateElement);
    taskElement.appendChild(taskPriorityElement);

    taskList.appendChild(taskElement);
}

function addCompletedTask(completedTask) {
    const completedTaskElement = document.createElement('div');
    completedTaskElement.classList.add('completed-task');

    completedTaskElement.innerHTML = `
        <span class="completed-task-name">${completedTask.name}</span>
        <span class="completed-task-completion-date">${completedTask.completionDate}</span>
        <span class="completed-task-completed-by">${completedTask.completedBy}</span>
    `;

    completedTaskList.append(completedTaskElement);
}
function addCompletedTask(completedTask) {
    const completedTaskElement = document.createElement('div');
    completedTaskElement.classList.add('completed-task');

    const completedTaskNameElement = document.createElement('span');
    completedTaskNameElement.classList.add('completed-task-name');
    completedTaskNameElement.innerText = completedTask.name;

    const completedTaskCompletionDateElement = document.createElement('span');
    completedTaskCompletionDateElement.classList.add('completed-task-completion-date');
    completedTaskCompletionDateElement.innerText = completedTask.completionDate;

    const completedTaskCompletedByElement = document.createElement('span');
    completedTaskCompletedByElement.classList.add('completed-task-completed-by');
    completedTaskCompletedByElement.innerText = completedTask.completedBy;

    completedTaskElement.appendChild(completedTaskNameElement);
    completedTaskElement.appendChild(completedTaskCompletionDateElement);
    completedTaskElement.appendChild(completedTaskCompletedByElement);

    completedTaskList.appendChild(completedTaskElement);
}
function getTasks() {
    return fetch(BASE_URL + 'tasks')
        .then(response => response.json())
        .then(tasks => tasks.forEach(addTask))
        .catch(error => console.error(error));
}


function getCompletedTasks() {
    return fetch(BASE_URL + 'completed-tasks')
        .then(response => response.json())
        .then(completedTasks => completedTasks.forEach(addCompletedTask))
        .catch(error => console.error(error));
}


function submitForm(event) {
    event.preventDefault();

    const formData = new FormData(form);
    const name = formData.get('name');
    const dueDate = formData.get('due-date');
    const priority = formData.get('priority');
    const notes = formData.get('notes');
    const attachments = formData.get('attachments');

    const data = {
        name: name,
        dueDate: dueDate,
        priority: priority,
        notes: notes,
        attachments: attachments
    };

    fetch('/api/tasks', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(task => {
            addTask(task);
            form.reset();
        });
}

// Get the task form and add an event listener for the submit event
const taskForm = document.getElementById('task-form');
taskForm.addEventListener('submit', event => {
    // Prevent the form from actually submitting
    event.preventDefault();

    // Get the values of the task name, due date, priority, and notes from the form
    const taskName = document.getElementById('task-name').value;
    const taskDueDate = document.getElementById('task-due-date').value;
    const taskPriority = document.getElementById('task-priority').value;
    const taskNotes = document.getElementById();

});

// Fetch the list of tasks from the backend and insert them into the page
fetch('/api/tasks')
    .then(response => response.json())
    .then(tasks => {
        const taskList = document.getElementById('task-list');
        for (const task of tasks) {
            const div = document.createElement('div');
            div.className = 'task';
            div.innerHTML = `
                <span class="task-name">${task.name}</span>
                <span class="task-due-date">${task.dueDate}</span>
                <span class="task-priority">${task.priority}</span>
            `;
            taskList.appendChild(div);
        }
    });

// Fetch the list of completed tasks from the backend and insert them into the page
fetch('/api/completed-tasks')
    .then(response => response.json())
    .then(completedTasks => {
        const completedTaskList = document.getElementById('completed-task-list');
        for (const completedTask of completedTasks) {
            const div = document.createElement('div');
            div.className = 'completed-task';
            div.innerHTML = `
                <span class="completed-task-name">${completedTask.name}</span>
                <span class="completed-task-completion-date">${completedTask.completionDate}</span>
                <span class="completed-task-completed-by">${completedTask.completedBy}</span>
            `;
            completedTaskList.appendChild(div);
        }
    });



// fetch('/api/tasks'): This fetch call can be used to retrieve a list of tasks from the server.
// fetch('/api/tasks/{taskId}'): This fetch call can be used to retrieve a specific task by its ID from the server.
// fetch('/api/tasks', {method: 'POST'}): This fetch call can be used to create a new task on the server.
// fetch('/api/tasks/{taskId}', {method: 'PUT'}): This fetch call can be used to update an existing task on the server.
// fetch('/api/tasks/{taskId}', {method: 'DELETE'}): This fetch call can be used to delete a task from the server.
// fetch('/api/completed-tasks'): This fetch call can be used to retrieve a list of completed tasks from the server.
// fetch('/api/completed-tasks/{completedTaskId}'): This fetch call can be used to retrieve a specific completed task by its ID from the server.
// fetch('/api/completed-tasks', {method: 'POST'}): This fetch call can be used to create a new completed task on the server.
// fetch('/api/completed-tasks/{completedTaskId}', {method: 'DELETE'}): This fetch call can be used to delete a completed task from the server.
