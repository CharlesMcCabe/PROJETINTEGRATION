const html = {
    
    loginButton: document.getElementById("login"),
    registerButton: document.getElementById("register"),
    closeButton: document.getElementById("close"),
    title: document.getElementById("title"),
    search: document.getElementById("search"),
    searchSubmit: document.getElementById("searchSubmit"),
    back: document.getElementById("back"),
    backButton: document.getElementById("backButton"),
    accountButton: document.getElementById("accountButton"),
    sectionAction: document.getElementById("sectionAction")
};

html.title.style.display = "block";
html.search.style.display = "block";
html.backButton.style.display = "none";
html.sectionAction.style.display = "none";


html.searchSubmit.addEventListener("click", () => {
    console.log("searchSubmit");
    html.title.style.display = "none";
    html.search.style.display = "none";
    html.backButton.style.display = "block";
    html.sectionAction.style.display = "block";
})


html.back.addEventListener("click", () => {
    console.log("Return");
    html.title.style.display = "block";
    html.search.style.display = "block";
    html.backButton.style.display = "none";
    html.sectionAction.style.display = "none";
})