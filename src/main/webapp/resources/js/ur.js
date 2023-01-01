
    function isValid() {
    alert("I am working2 ");
//     const username =pForm.username.value ;
//     const pass     = pForm.password.value;
//
//     if(username ===""){
//     document.getElementById("userErr").innerHTML="Invalid Username";
//     return false;
// }else{
//     document.getElementById("userErr").innerHTML=" ";
// }
//
//     if(pass ===""){
//     document.getElementById("passErr").innerHTML="Invalid Password";
//     return false;
// }
//     else{
//     document.getElementById("passErr").innerHTML=" ";
//}
    return false;
}
    function myFunction() {
    const x = document.getElementById("password");
    if (x.type === "password"){
    x.type = "text";
}else{
    x.type = "password";
}
}