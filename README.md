# ProyLenguajes
para correrlo en eclipse, deben tener un servidor, yo tengo wildfly pero segun yo sirve con el q sea.
entonces importan el proyecto drools a eclipse y le ponen run on server. Debe decirles en consola q no hay pedos, osea INFO o WARN maximo; y se abrirá una pestana de explorador en eclipse para que sepan q ya está corriendo.
Si sale ERROR pues ya ahi pasa algo. No se preocupen por la pestana de explorador que abre eclipse automáticamente si dice not found o algo asi, el chiste es probarlo con postman. si ya ahi no les responde con un objeto json hay problemas. 
usando postman o algo similar si tienen otro, pueden hacer get y post.
ahorita tengo otras clases/objetos q usaba de ejemplo, eso de padre y hermano es de la tarea tons no lo tomen en cuenta; ahorita solo estudiante importa (y materia y tema, tal vez maestro lo podamos incluir). (src/main/java/com.trucutru.model)

**********************************************

Instrucciones para pruebas en Postman:

-> -> endpoint: http://localhost:8080/restdrools/estudiantes/inserta con POST
ejemplo estudiante:
{
	"nombre": "jose lopez portillo",
	"promedioGlobal": "0.0",
	"recomendaciones": []
}

-> -> endpoint: http://localhost:8080/restdrools/estudiantes/ con GET
te da lista de alumnos y con /estudiantes/id te da el alumno en especifico
--------------

-> -> endpoint: http://localhost:8080/restdrools/materias/inserta con POST
ejemplo:
{
	"nombre": "Fisica",
	"maestro": "Rafel Lozano Espinosa",
	"nivelCurso": 7
}
-> -> endpoint: http://localhost:8080/restdrools/materias/ con GET
te da lista de materias y con /materias/id te da la materia en especifico
----------------

-> -> endpoint: http://localhost:8080/restdrools/estud_mat/inserta con POST
ejemplo estudiante_materia:
{
	"id_materia": "1",
	"id_estudiante": "1",
	"promedioAlumno": 0.0,
	"procentajeCompletado": 0.0
}
con GET pasa lo mismo q con lo anteriores: /estud_mat y /estud_mat/{id_est}/{id_mat}
-------------------

-> -> endpoint: http://localhost:8080/restdrools/temas/inserta con POST
ejemplo temas:
{
	"id_materia": "1",
	"nombre": "MRUA",
	"nivel": 6
}
GET: /temas y temas/id
---------------------

-> -> endpoint: http://localhost:8080/restdrools/tema_estud/inserta con POST
ejemplo tema estud
{
	"id_tema": "1",
	"id_estudiante": "1",
	"promedio_ejercicios": 0.0
}
GET: tema_estud y tema_estud/{id_est}/{id_tem}
-------------------------

-> -> endpoint: http://localhost:8080/restdrools/tareas/inserta con POST
ejemplo tareas
{
	"id_tema": "1",
	"nombre": "Ejercicio 1",
	"dificultad": 6
}
GET: tareas y tareas/id
---------------------------

-> -> endpoint: http://localhost:8080/restdrools/tarea_estud/inserta con POST
ejemplo tareas_estudiantes
{
	"id_tarea": "1",
	"id_tema": "1",
	"id_estudiante": "1",
	"califiacion": 56.0
}
GET: /tarea_estud y tarea_estud/{id_est}/{id_tem}/{id_tar}
