USE preoperationaldb;

-- Insertar Roles
INSERT INTO role (id_role, role_name) VALUES (1, 'Administrador');
INSERT INTO role (id_role, role_name) VALUES (2, 'Supervisor');
INSERT INTO role (id_role, role_name) VALUES (3, 'Operador');

-- Insertar Áreas
INSERT INTO area (id_area, name_area) VALUES (1, 'Logística');
INSERT INTO area (id_area, name_area) VALUES (2, 'Producción');
INSERT INTO area (id_area, name_area) VALUES (3, 'Mantenimiento');

-- Insertar Posiciones
INSERT INTO position (id_position, name_position) VALUES (1, 'Jefe de Área');
INSERT INTO position (id_position, name_position) VALUES (2, 'Analista');
INSERT INTO position (id_position, name_position) VALUES (3, 'Técnico');

-- Insertar Usuarios
INSERT INTO user (id_user, user_name, user_state, user_type, idf_role, idf_area, idf_position) VALUES ('U001', 'Juan Pérez', 'Activo', 'Interno', 1, 1, 1);
INSERT INTO user (id_user, user_name, user_state, user_type, idf_role, idf_area, idf_position) VALUES ('U002', 'María López', 'Activo', 'Externo', 2, 2, 2);
INSERT INTO user (id_user, user_name, user_state, user_type, idf_role, idf_area, idf_position) VALUES ('U003', 'Carlos Sánchez', 'Inactivo', 'Interno', 3, 3, 3);

-- Insertar Encuestas
INSERT INTO survey (id_survey, name_survey, survey_description, survey_state) VALUES (1, 'Encuesta Preoperacional', 'Evaluación del estado del vehículo', TRUE);
INSERT INTO survey (id_survey, name_survey, survey_description, survey_state) VALUES (2, 'Encuesta de Satisfacción', 'Opinión sobre las condiciones de trabajo', FALSE);
INSERT INTO survey (id_survey, name_survey, survey_description, survey_state)  VALUES (3, 'Encuesta Técnica', 'Evaluación del desempeño de equipos', FALSE);

-- Insertar Tipos de Pregunta
INSERT INTO question_type (id_qtype, qtype_name) VALUES (1, 'Opción Múltiple');
INSERT INTO question_type (id_qtype, qtype_name) VALUES (2, 'Abierta');
INSERT INTO question_type (id_qtype, qtype_name) VALUES (3, 'Escala de Likert');

-- Insertar Preguntas
INSERT INTO question (id_question, question_text, idf_survey, idf_qtype) VALUES (1, '¿Cómo calificaría la seguridad en su área de trabajo?', 1, 3);
INSERT INTO question (id_question, question_text, idf_survey, idf_qtype) VALUES (2, '¿Qué mejoras sugeriría para el ambiente laboral?', 2, 2);
INSERT INTO question (id_question, question_text, idf_survey, idf_qtype) VALUES (3, '¿Qué equipo utiliza con mayor frecuencia?', 3, 1);

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
INSERT INTO question_response (id_response, response_date, response, idf_user, idf_question) VALUES (2, '2024-02-11', 'Más áreas de descanso', 'U002', 2);
INSERT INTO question_response (id_response, response_date, response, idf_user, idf_question) VALUES (3, '2024-02-12', 'Montacargas', 'U003', 3);
