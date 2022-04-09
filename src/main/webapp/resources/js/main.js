/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const addToCart = (id, name, price) =>{
    event.preventDefault();
    
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

const updateCart = (id, obj) =>  {
    event.preventDefault();

    fetch("/A3SpringMVCDemo/api/update-cart", {
        method: 'put',
        body: JSON.stringify({
            "id": id,
            "quantity": obj.value
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json()).then(data => {
        console.info(data)
        let carts = document.getElementsByClassName('cartCounter')
        for (let i = 0; i < carts.length; i++)
            carts[i].innerText = data.totalQuantity;
        let amount = document.getElementsByClassName('cartAmount')
        for (let i = 0; i < amount.length; i++)
            amount[i].innerText = data.totalAmount;
    })
}

const deleteCart = (id) => {
    if (confirm("Are u sure delete this item?") == true) {
        event.preventDefault();

        fetch(`/A3SpringMVCDemo/api/delete-cart/${id}` , {
            method: 'delete',
           
        }).then(res => res.json()).then(data => {
            console.info(data)
            let carts = document.getElementsByClassName('cartCounter')
            for (let i = 0; i < carts.length; i++)
                carts[i].innerText = data.totalQuantity;
            let amount = document.getElementsByClassName('cartAmount')
            for (let i = 0; i < amount.length; i++)
                amount[i].innerText = data.totalAmount;
            
          location.reload()
//            let d = documemt.getElementById(`product${id}`)
//            d.style.display = "none"
        })
    }
}