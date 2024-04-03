-- Inserciones para la tabla 'sedes'
INSERT INTO sedes (nombre_sede, direccion, ciudad, nombre_director) VALUES ('Sede Central', 'Calle Principal 123', 'Ciudad Central', 'Juan Perez');

INSERT INTO sedes (nombre_sede, direccion, ciudad, nombre_director) VALUES ('Sede Norte', 'Avenida Norte 456', 'Ciudad Norte', 'Maria Lopez');

INSERT INTO sedes (nombre_sede, direccion, ciudad, nombre_director) VALUES ('Sede Sur', 'Calle Sur 789', 'Ciudad Sur', 'Carlos Ramirez');

INSERT INTO sedes (nombre_sede, direccion, ciudad, nombre_director) VALUES ('Sede Este', 'Avenida Este 012', 'Ciudad Este', 'Laura Gonzalez');

INSERT INTO sedes (nombre_sede, direccion, ciudad, nombre_director) VALUES ('Sede Oeste', 'Calle Oeste 345', 'Ciudad Oeste', 'Pedro Martinez');

-- Inserciones para la tabla 'persona'
INSERT INTO persona (nombre, apellido, direccion, telefono, email) VALUES ('Ana', 'Garcia', 'Calle 1', '123456789', 'ana@example.com');

INSERT INTO persona (nombre, apellido, direccion, telefono, email) VALUES ('Luis', 'Perez', 'Calle 2', '987654321', 'luis@example.com');

INSERT INTO persona (nombre, apellido, direccion, telefono, email) VALUES ('Maria', 'Rodriguez', 'Calle 3', '111222333', 'maria@example.com');

INSERT INTO persona (nombre, apellido, direccion, telefono, email) VALUES ('Carlos', 'Lopez', 'Calle 4', '444555666', 'carlos@example.com');

INSERT INTO persona (nombre, apellido, direccion, telefono, email) VALUES ('Laura', 'Martinez', 'Calle 5', '777888999', 'laura@example.com');

-- Inserciones para la tabla 'socio'
INSERT INTO socio (persona_id, ciudad, cuenta_bancaria, fecha_pago, sede_id) VALUES (1, 'Ciudad Central', '1234567890', '2024-03-01', 1);

INSERT INTO socio (persona_id, ciudad, cuenta_bancaria, fecha_pago, sede_id) VALUES (2, 'Ciudad Norte', '2345678901', '2024-03-02', 2);

INSERT INTO socio (persona_id, ciudad, cuenta_bancaria, fecha_pago, sede_id) VALUES (3, 'Ciudad Sur', '3456789012', '2024-03-03', 3);

INSERT INTO socio (persona_id, ciudad, cuenta_bancaria, fecha_pago, sede_id) VALUES (4, 'Ciudad Este', '4567890123', '2024-03-04', 4);

INSERT INTO socio (persona_id, ciudad, cuenta_bancaria, fecha_pago, sede_id) VALUES (5, 'Ciudad Oeste', '5678901234', '2024-03-05', 5);

-- Inserciones para la tabla 'voluntarios'
INSERT INTO voluntarios (persona_id, profesion, disponibilidad, num_trabajos, sede_id) VALUES (1, 'Enfermera', 1, 5, 1);

INSERT INTO voluntarios (persona_id, profesion, disponibilidad, num_trabajos, sede_id) VALUES (2, 'Doctor', 1, 3, 2);

INSERT INTO voluntarios (persona_id, profesion, disponibilidad, num_trabajos, sede_id) VALUES (3, 'Psicóloga', 1, 2, 3);

INSERT INTO voluntarios (persona_id, profesion, disponibilidad, num_trabajos, sede_id) VALUES (4, 'Enfermero', 1, 4, 4);

INSERT INTO voluntarios (persona_id, profesion, disponibilidad, num_trabajos, sede_id) VALUES (5, 'Voluntario general', 1, 1, 5);

-- Inserciones para la tabla 'envios'
INSERT INTO envios (codigo, destino, fecha_salida) VALUES ('COD001', 'Ciudad Destino 1', '2024-03-10');

INSERT INTO envios (codigo, destino, fecha_salida) VALUES ('COD002', 'Ciudad Destino 2', '2024-03-11');

INSERT INTO envios (codigo, destino, fecha_salida) VALUES ('COD003', 'Ciudad Destino 3', '2024-03-12');

INSERT INTO envios (codigo, destino, fecha_salida) VALUES ('COD004', 'Ciudad Destino 4', '2024-03-13');

INSERT INTO envios (codigo, destino, fecha_salida) VALUES ('COD005', 'Ciudad Destino 5', '2024-03-14');

-- Inserciones para la tabla 'envio_sede'
INSERT INTO envio_sede (envio_id, sede_id) VALUES (1, 1);

INSERT INTO envio_sede (envio_id, sede_id) VALUES (2, 2);

INSERT INTO envio_sede (envio_id, sede_id) VALUES (3, 3);

INSERT INTO envio_sede (envio_id, sede_id) VALUES (4, 4);

INSERT INTO envio_sede (envio_id, sede_id) VALUES (5, 5);

-- Inserciones para la tabla 'detalle_envio_material'
INSERT INTO detalle_envio_material (id_envio, tipo_material, cantidad) VALUES (1, 'ALIMENTOS', 100);

INSERT INTO detalle_envio_material (id_envio, tipo_material, cantidad) VALUES (2, 'MEDICAMENTOS', 50);

INSERT INTO detalle_envio_material (id_envio, tipo_material, cantidad) VALUES (3, 'ALIMENTOS', 75);

INSERT INTO detalle_envio_material (id_envio, tipo_material, cantidad) VALUES (4, 'MEDICAMENTOS', 30);

INSERT INTO detalle_envio_material (id_envio, tipo_material, cantidad) VALUES (5, 'ALIMENTOS', 120);

-- Inserciones para la tabla 'cuota'
INSERT INTO cuota (tipo_cuota, monto, socio_id) VALUES ('MINIMA', 50.00, 1);

INSERT INTO cuota (tipo_cuota, monto, socio_id) VALUES ('MEDIA', 100.00, 2);

INSERT INTO cuota (tipo_cuota, monto, socio_id) VALUES ('MAXIMA', 150.00, 3);

INSERT INTO cuota (tipo_cuota, monto, socio_id) VALUES ('MINIMA', 50.00, 4);

INSERT INTO cuota (tipo_cuota, monto, socio_id) VALUES ('MEDIA', 100.00, 5);

-- Inserciones para la tabla 'detalle_envio_humanitario'
INSERT INTO detalle_envio_humanitario (id_envio, cantidad_voluntarios, profesion_voluntario) VALUES (1, 5, 'Enfermeras');

INSERT INTO detalle_envio_humanitario (id_envio, cantidad_voluntarios, profesion_voluntario) VALUES (2, 3, 'Doctores');

INSERT INTO detalle_envio_humanitario (id_envio, cantidad_voluntarios, profesion_voluntario) VALUES (3, 2, 'Psicólogas');

INSERT INTO detalle_envio_humanitario (id_envio, cantidad_voluntarios, profesion_voluntario) VALUES (4, 4, 'Enfermeros');

INSERT INTO detalle_envio_humanitario (id_envio, cantidad_voluntarios, profesion_voluntario) VALUES (5, 1, 'Voluntarios generales');
