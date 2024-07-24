drop database if exists railway;

create database if not exists railway;

use railway;

create table documento(
	id_documento int not null primary key auto_increment,
    dni int not null,
    fecha date not null
);

-- Tipo de documento
create table tipos_documento(
	id_tipo int not null primary key auto_increment,
    nombre varchar(40) not null,
    id_documento int not null,
    foreign key(id_documento) references documento(id_documento)
);

-- Cliente
create table clientes(
	id_cliente int not null primary key auto_increment,
    nombre varchar(30) not null,
    correo varchar(100) not null,
    password varchar(20) not null,
    telefono bigint not null,
    codTel varchar(4) not null,
    rolUser varchar(40) not null,
    numDocId bigint not null,
    id_tipo int not null,
    tgsDocId varchar(3),
    foreign key(id_tipo) references tipos_documento(id_tipo)
);

-- Viajes
create table viajes(
	id_viaje int not null primary key auto_increment,
    fecha_viaje date not null,
    precio_viaje double not null
);

-- Reserva de viaje
create table reserva_viaje(
	id_reserva int not null primary key auto_increment,
	id_viaje int not null,
    fecha_reserva date not null,
    foreign key(id_viaje) references viajes(id_viaje)
);

-- Tarifas de vuelo
create table tarifas_vuelo(
	id_tarifa int not null primary key auto_increment,
    descripcion varchar(20) not null,
    detalles text null,
    valor double(7,3) not null
);

-- Detalles de la reserva de viaje
create table detalles_reserva_viaje(
	id_detalle int not null primary key auto_increment,
    id_reserva int not null,
    id_cliente int not null, 
    id_tarifa int not null,
    foreign key(id_reserva) references reserva_viaje(id_reserva),
    foreign key(id_cliente) references clientes(id_cliente),
    foreign key(id_tarifa) references tarifas_vuelo(id_tarifa)
);

-- Aerolíneas
create table aerolineas(
	id_aerolinea int not null primary key auto_increment,
    aerolinea varchar(40) not null
);

-- Rol de la tripulación
create table roles_tripulacion(
	id_rol int not null primary key auto_increment,
    nombre varchar(40) not null
);

-- Países
create table paises(
	id_pais int not null primary key auto_increment,
    nombre varchar(30) not null
);

-- Ciudades
create table ciudades(
	id_ciudad int not null primary key auto_increment,
    nombre varchar(30) not null,
    id_pais int not null,
    foreign key(id_pais) references paises(id_pais)
);

-- Aeropuertos
create table aeropuertos(
	id_aeropuerto int not null primary key auto_increment,
    nombre varchar(50) not null,
    codigo varchar(5) not null,
    id_ciudad int not null,
    foreign key(id_ciudad) references ciudades(id_ciudad)
);

-- Empleados
create table empleados(
	id_empleado int not null primary key auto_increment,
    nombre varchar(40) not null,
    id_rol int not null,
    fecha_ingreso date not null,
    id_aerolinea int not null,
    id_aeropuerto int not null,
    id_documento int not null,
    foreign key(id_rol) references roles_tripulacion(id_rol),
    foreign key(id_aerolinea) references aerolineas(id_aerolinea),
    foreign key(id_aeropuerto) references aeropuertos(id_aeropuerto),
    foreign key(id_documento) references documento(id_documento)
);

-- Puertas de embarque
create table puertas_embarque(
	id_puerta int not null primary key auto_increment,
    numero_puerta varchar(10) not null,
    id_aeropuerto int not null,
    foreign key(id_aeropuerto) references aeropuertos(id_aeropuerto)
);

-- Detalles de revisión
create table detalles_revision(
	id_revision int not null primary key auto_increment,
    descripcion text not null,
    id_empleado int not null,
    foreign key(id_empleado) references empleados(id_empleado)
);

-- Fabricantes
create table fabricantes(
	id_fabricante int not null primary key auto_increment ,
    nombre varchar(40) not null
);

-- Modelos
create table modelos(
	id_modelo int not null primary key auto_increment,
    modelo varchar(30) not null,
    id_fabricante int not null,
    foreign key(id_fabricante) references fabricantes(id_fabricante)
);

-- Estados
create table estados(
	id_estado int not null primary key auto_increment,
    estado varchar(30) not null
);

-- Aviones
create table aviones(
	id_avion int not null primary key auto_increment,
    placas varchar(30) not null,
    capacidad int not null,
    fecha_fabricacion date not null,
    id_estado int not null,
    id_modelo int not null,
    foreign key(id_estado) references estados(id_estado),
    foreign key(id_modelo) references modelos(id_modelo)
);

-- Revisiones
create table revisiones(
	id_revision int not null primary key auto_increment,
    fecha_revision date not null,
    id_avion int not null,
    foreign key(id_avion) references aviones(id_avion)
);

-- Revisiones del empleado
create table revisiones_empleado(
	id_empleado int not null,
    id_revision int not null,
    foreign key(id_empleado) references empleados(id_empleado),
    foreign key(id_revision) references revisiones(id_revision)
);

-- Conexiones
create table conexiones(
	id_conexion int not null primary key auto_increment,
    numero_conexion varchar(20) not null,
    id_viaje int not null,
    id_avion int not null,
    id_aeropuerto int not null,
    foreign key(id_viaje) references viajes(id_viaje),
	foreign key(id_avion) references aviones(id_avion),
    foreign key(id_aeropuerto) references aeropuertos(id_aeropuerto)
);

-- Tripulación del vuelo
create table tripulacion_vuelo(
	id_empleado int not null,
    id_conexion int not null,
    foreign key(id_empleado) references empleados(id_empleado),
    foreign key(id_conexion) references conexiones(id_conexion)
);


-- Insertando datos para la base de datos.

-- Insert data into 'documento'
INSERT INTO documento (dni, fecha) VALUES 
(12345678, '2022-01-01'),
(87654321, '2022-02-01'),
(23456789, '2022-03-01'),
(98765432, '2022-04-01'),
(34567890, '2022-05-01');

-- Insert data into 'tipos_documento'
INSERT INTO tipos_documento (nombre, id_documento) VALUES 
('Passport', 1),
('Driver License', 2),
('ID Card', 3),
('Visa', 4),
('Residence Permit', 5);

-- Insert data into 'clientes'
INSERT INTO clientes (nombre, correo, password, telefono, codTel, rolUser, numDocId, id_tipo, tgsDocId) VALUES 
('John Doe', 'john@example.com', 'pass123', 1234567890, '001', 'admin', 1, 1, 'USA'),
('Jane Smith', 'jane@example.com', 'pass456', 2345678901, '002', 'user', 2, 2, 'CAN'),
('Carlos Gomez', 'carlos@example.com', 'pass789', 3456789012, '003', 'user', 3, 3, 'MEX'),
('Linda Park', 'linda@example.com', 'pass012', 4567890123, '004', 'admin', 4, 4, 'KOR'),
('Emma Brown', 'emma@example.com', 'pass345', 5678901234, '005', 'user', 5, 5, 'UK');

-- Insert data into 'viajes'
INSERT INTO viajes (fecha_viaje, precio_viaje) VALUES 
('2023-06-15', 150.00),
('2023-07-20', 200.00),
('2023-08-25', 250.00),
('2023-09-10', 300.00),
('2023-10-05', 350.00);

-- Insert data into 'reserva_viaje'
INSERT INTO reserva_viaje (id_viaje, fecha_reserva) VALUES 
(1, '2023-01-01'),
(2, '2023-02-01'),
(3, '2023-03-01'),
(4, '2023-04-01'),
(5, '2023-05-01');

-- Insert data into 'tarifas_vuelo'
INSERT INTO tarifas_vuelo (descripcion, detalles, valor) VALUES 
('Economy', 'Basic economy class', 100.000),
('Business', 'Business class', 200.000),
('First', 'First class', 300.000),
('Premium Economy', 'Premium economy class', 150.000),
('Ultra Economy', 'Ultra economy class', 50.000);

-- Insert data into 'detalles_reserva_viaje'
INSERT INTO detalles_reserva_viaje (id_reserva, id_cliente, id_tarifa) VALUES 
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

-- Insert data into 'aerolineas'
INSERT INTO aerolineas (aerolinea) VALUES 
('American Airlines'),
('Delta Airlines'),
('United Airlines'),
('Southwest Airlines'),
('JetBlue Airways');

-- Insert data into 'roles_tripulacion'
INSERT INTO roles_tripulacion (nombre) VALUES 
('Pilot'),
('Co-pilot'),
('Flight Attendant'),
('Ground Crew'),
('Air Traffic Controller');

-- Insert data into 'paises'
INSERT INTO paises (nombre) VALUES 
('United States'),
('Canada'),
('Mexico'),
('South Korea'),
('United Kingdom');

-- Insert data into 'ciudades'
INSERT INTO ciudades (nombre, id_pais) VALUES 
('New York', 1),
('Toronto', 2),
('Mexico City', 3),
('Seoul', 4),
('London', 5);

-- Insert data into 'aeropuertos'
INSERT INTO aeropuertos (nombre, codigo, id_ciudad) VALUES 
('JFK', 'JFK', 1),
('YYZ', 'YYZ', 2),
('MEX', 'MEX', 3),
('ICN', 'ICN', 4),
('LHR', 'LHR', 5);

-- Insert data into 'empleados'
INSERT INTO empleados (nombre, id_rol, fecha_ingreso, id_aerolinea, id_aeropuerto, id_documento) VALUES 
('Alice Johnson', 1, '2020-01-01', 1, 1, 1),
('Bob Lee', 2, '2020-02-01', 2, 2, 2),
('Charlie Kim', 3, '2020-03-01', 3, 3, 3),
('Diana Scott', 4, '2020-04-01', 4, 4, 4),
('Ethan Black', 5, '2020-05-01', 5, 5, 5);

-- Insert data into 'puertas_embarque'
INSERT INTO puertas_embarque (numero_puerta, id_aeropuerto) VALUES 
('A1', 1),
('B2', 2),
('C3', 3),
('D4', 4),
('E5', 5);

-- Insert data into 'detalles_revision'
INSERT INTO detalles_revision (descripcion, id_empleado) VALUES 
('Engine check', 1),
('Landing gear inspection', 2),
('Cabin cleaning', 3),
('Safety equipment check', 4),
('Fueling', 5);

-- Insert data into 'fabricantes'
INSERT INTO fabricantes (nombre) VALUES 
('Boeing'),
('Airbus');

-- Insert data into 'modelos'
INSERT INTO modelos (modelo, id_fabricante) VALUES 
('737', 1),
('A320', 2);

-- Insert data into 'estados'
INSERT INTO estados (estado) VALUES 
('Operational'),
('Under Maintenance');

-- Insert data into 'aviones'
INSERT INTO aviones (placas, capacidad, fecha_fabricacion, id_estado, id_modelo) VALUES 
('N12345', 150, '2015-01-01', 1, 1),
('N54321', 200, '2016-02-01', 2, 2),
('N67890', 100, '2017-03-01', 1, 2),
('N09876', 90, '2018-04-01', 2, 1),
('N11223', 180, '2019-05-01', 1, 2);

-- Insert data into 'revisiones'
INSERT INTO revisiones (fecha_revision, id_avion) VALUES 
('2023-01-15', 1),
('2023-02-20', 2),
('2023-03-25', 3),
('2023-04-10', 4),
('2023-05-05', 5);

-- Insert data into 'revisiones_empleado'
INSERT INTO revisiones_empleado (id_empleado, id_revision) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Insert data into 'conexiones'
INSERT INTO conexiones (numero_conexion, id_viaje, id_avion, id_aeropuerto) VALUES 
('C123', 1, 1, 1),
('C456', 2, 2, 2),
('C789', 3, 3, 3),
('C012', 4, 4, 4),
('C345', 5, 5, 5);

-- Insert data into 'tripulacion_vuelo'
INSERT INTO tripulacion_vuelo (id_empleado, id_conexion) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);


DELIMITER //

CREATE PROCEDURE ObtenerModelosAvion()
BEGIN
    SELECT id_modelo, modelo, id_fabricante FROM modelos;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ObtenerEstadosAvion()
BEGIN
    SELECT * FROM estados;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ObtenerPlacasAvion()
BEGIN
    SELECT placas FROM aviones;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertarAvion(
    IN p_placas VARCHAR(30),
    IN p_capacidad INT,
    IN p_fecha_fabricacion DATE,
    IN p_id_estado INT,
    IN p_id_modelo INT
)
BEGIN
    INSERT INTO aviones (placas, capacidad, fecha_fabricacion, id_estado, id_modelo)
    VALUES (p_placas, p_capacidad, p_fecha_fabricacion, p_id_estado, p_id_modelo);
END //

DELIMITER ;



