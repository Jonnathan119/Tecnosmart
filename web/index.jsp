<%-- 
    Document   : index
    Created on : 05/08/2024, 10:57:21 a. m.
    Author     : jonna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clientes Tecnosmart Samaná</title>
    
    <style>
        
        body {
            background-image: url("Images/Tecnosmart Samaná.jpg");
            background-size: cover; 
            background-position: center; 
            background-repeat: no-repeat;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #006666;
            padding: 20px;
            border-radius: 8px;
        }
        .container {
            width: 40%;
            margin: 0 auto;
            background: #006666;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px; 
            border-radius: 8px; 
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            display: flex;
            flex-direction: column;
            align-items: center
        }
        
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="date"], input[type="email"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button[type="submit"] {
            padding: 10px;
            background-color: #000000;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            text-align: center;
            
        }
        button[type="submit"]:hover {
            background-color: #999999;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>REGISTRO DE CLIENTES TECNOSMART</h2>
    <form action="RegistroCliente" method="post">
        <div class="form-group">
            <label for="numero_cedula">Número de Cédula:</label>
            <input type="text" id="numero_cedula" name="numero_cedula" required>
        </div>
        <div class="form-group">
            <label for="fecha_expedicion_cedula">Fecha de Expedición de la Cédula:</label>
            <input type="date" id="fecha_expedicion_cedula" name="fecha_expedicion_cedula" required>
        </div>
        <div class="form-group">
            <label for="nombre">Nombre Completo:</label>
            <input type="text" id="nombre" name="nombre" required>
        </div>
        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <input type="text" id="telefono" name="telefono" required>
        </div>
        <div class="form-group">
            <label for="direccion">Dirección:</label>
            <input type="text" id="direccion" name="direccion" required>
        </div>
        <div class="form-group">
            <label for="correo_electronico">Correo Electrónico:</label>
            <input type="email" id="correo_electronico" name="correo_electronico" required>
        </div>
        <button type="submit">Registrar</button>
    </form>
</div>

</body>
</html>