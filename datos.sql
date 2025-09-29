INSERT INTO evento (id,nombre, fecha, lugar) VALUES (1,'Concierto de Rock', '2024-12-15', 'Estadio Nacional');
INSERT INTO evento (id,nombre, fecha, lugar) VALUES (2,'Conferencia de Tecnología', '2024-10-20', 'Centro de Convenciones');
INSERT INTO evento (id,nombre, fecha, lugar) VALUES (3,'Festival de Jazz', '2024-11-05', 'Parque Central');

INSERT INTO asistente (rut,nombre, email) VALUES (217638392,'Juan Pérez', 'juan.perez@ucn.cl');
INSERT INTO asistente (rut,nombre, email) VALUES (64389216,'María López', 'maria.lopez@ucn.cl');
INSERT INTO asistente (rut,nombre, email) VALUES (127382682,'Carlos Sánchez', 'carlos.sanchez@ucn.cl');

INSERT INTO evento_asistente (id_evento, rut) VALUES (1, 217638392);
INSERT INTO evento_asistente (id_evento, rut) VALUES (1, 64389216);
INSERT INTO evento_asistente (id_evento, rut) VALUES (2, 127382682);
INSERT INTO evento_asistente (id_evento, rut) VALUES (3, 217638392);