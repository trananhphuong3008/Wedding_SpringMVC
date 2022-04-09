/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const addToCart = (id, name, price) =>{
    fetch("/A3SpringMVCDemo/api/add-cart", {
        method: 'post',
        body: JSON.stringify({
            "id": id,
            "name": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json()).then(data =>{
        console.info(data)
        let carts = document.getElementsByClassName('cartCounter')
        for (let i =0; i<carts.length;i++)
            carts[i].innerText = data.totalQuantity;
    })
}