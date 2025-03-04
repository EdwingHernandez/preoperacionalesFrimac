USE preoperationaldb;

-- Insertar Roles
INSERT INTO role (id_role, role_name) VALUES (1, 'Administrador');
INSERT INTO role (id_role, role_name) VALUES (2, 'Supervisor');
INSERT INTO role (id_role, role_name) VALUES (3, 'Operador');

-- Insertar Áreas
INSERT INTO area (id_area, name_area) VALUES (1, 'Logistica');
INSERT INTO area (id_area, name_area) VALUES (2, 'Produccion');
INSERT INTO area (id_area, name_area) VALUES (3, 'Mantenimiento');

-- Insertar Posiciones
INSERT INTO position (id_position, name_position) VALUES (1, 'Jefe de Area');
INSERT INTO position (id_position, name_position) VALUES (2, 'Analista');
INSERT INTO position (id_position, name_position) VALUES (3, 'Tecnico');

-- Insertar Usuarios
INSERT INTO user (id_user, user_name, user_state, user_type, idf_role, idf_area, idf_position) VALUES ('U001', 'Juan Perez', 'Activo', 'Interno', 1, 1, 1);
INSERT INTO user (id_user, user_name, user_state, user_type, idf_role, idf_area, idf_position) VALUES ('U002', 'Maria López', 'Activo', 'Externo', 2, 2, 2);
INSERT INTO user (id_user, user_name, user_state, user_type, idf_role, idf_area, idf_position) VALUES ('U003', 'Carlos Sanchez', 'Inactivo', 'Interno', 3, 3, 3);

-- Insertar Encuestas
INSERT INTO survey (id_survey, name_survey, survey_description, survey_state) VALUES (1, 'Encuesta Preoperacional', 'Evaluacion del estado del vehiculo', TRUE);
INSERT INTO survey (id_survey, name_survey, survey_description, survey_state) VALUES (2, 'Encuesta de Satisfaccion', 'Opinion sobre las condiciones de trabajo', FALSE);
INSERT INTO survey (id_survey, name_survey, survey_description, survey_state)  VALUES (3, 'Encuesta Tecnica', 'Evaluacion del rendimiento de equipos', FALSE);

-- Insertar Tipos de Pregunta
INSERT INTO question_type (id_qtype, qtype_name) VALUES (1, 'Opcion Múltiple');
INSERT INTO question_type (id_qtype, qtype_name) VALUES (2, 'Abierta');
INSERT INTO question_type (id_qtype, qtype_name) VALUES (3, 'Escala de Likert');

-- Insertar Preguntas

INSERT INTO question (id_question, question_text, idf_survey, idf_qtype) VALUES (1, 'Numero de identificacion', 1, 1);
INSERT INTO question (id_question, question_text, idf_survey, idf_qtype) VALUES (2, 'Novedades para el no diligenciamiento de la inspeccion preoperacional', 1, 2);
INSERT INTO question (id_question, question_text, idf_survey, idf_qtype) VALUES (3, '003 - TIPO DE VEHICULO', 1, 2);


-- Opciones para la pregunta de novedades (id_question = 2)
INSERT INTO options (option_text, idf_question) VALUES ('Ninguna, Realizar encuesta', 2);
INSERT INTO options (option_text, idf_question) VALUES ('Vehiculo en taller', 2);
INSERT INTO options (option_text, idf_question) VALUES ('Conductor incapacitado', 2);
INSERT INTO options (option_text, idf_question) VALUES ('Parada de Planta/Bodega del cliente', 2);
INSERT INTO options (option_text, idf_question) VALUES ('Otra, ¿Indique cual?', 2);

-- Opciones para la pregunta de tipo de vehículo (id_question = 3)
INSERT INTO options (option_text, idf_question) VALUES ('TM-Tractomula', 3);
INSERT INTO options (option_text, idf_question) VALUES ('DBL-Doble Troque', 3);
INSERT INTO options (option_text, idf_question) VALUES ('SEN-Sencillo', 3);
INSERT INTO options (option_text, idf_question) VALUES ('CAM-Camioneta', 3);
INSERT INTO options (option_text, idf_question) VALUES ('TURB-Turbo', 3);
INSERT INTO options (option_text, idf_question) VALUES ('TM UF-Tractomula Refrigerada', 3);
INSERT INTO options (option_text, idf_question) VALUES ('DBL UF-Doble Troque Refrigerado', 3);
INSERT INTO options (option_text, idf_question) VALUES ('TURB UF-Turbo Refrigerado', 3);




-- Insertar Asignaciones de Encuestas
INSERT INTO survey_assignment (id_assignment, assignment_date, idf_user, idf_survey) VALUES (1, '2024-02-01', 'U001', 1);
INSERT INTO survey_assignment (id_assignment, assignment_date, idf_user, idf_survey) VALUES (2, '2024-02-02', 'U002', 2);
INSERT INTO survey_assignment (id_assignment, assignment_date, idf_user, idf_survey) VALUES (3, '2024-02-03', 'U003', 3);

-- Insertar Completación de Encuestas
INSERT INTO survey_completion (id_completion, completion_date, iscompleted, idf_user, idf_survey) VALUES (1, '2024-02-10', TRUE, 'U001', 1);
INSERT INTO survey_completion (id_completion, completion_date, iscompleted, idf_user, idf_survey) VALUES (2, '2024-02-11', FALSE, 'U002', 2);
INSERT INTO survey_completion (id_completion, completion_date, iscompleted, idf_user, idf_survey) VALUES (3, '2024-02-12', TRUE, 'U003', 3);

-- Insertar Respuestas a Preguntas
INSERT INTO question_response (id_response, response_date, response, idf_user, idf_question) VALUES (1, '2024-02-10', 'Muy Segura', 'U001', 1);
INSERT INTO question_response (id_response, response_date, response, idf_user, idf_question) VALUES (2, '2024-02-11', 'Mas areas de descanso', 'U002', 2);
INSERT INTO question_response (id_response, response_date, response, idf_user, idf_question) VALUES (3, '2024-02-12', 'Montacargas', 'U003', 3);
