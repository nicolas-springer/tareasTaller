# tareasTaller
Proyecto para taller mecánico para el control y registro de la asignación de tareas. Sabiendo que una tarea vincúla a un Cliente (con un Vehiculo) y un Mecanico. BD: Postgres + Hibernate.
En el archivo "Informe Proyecto Habilitacion Profesional - Springer Nicolas" se encuentra una explicacion mas detallada de las distintas funcionalidades del sistema.


# Ejecucion:
Ejecutar el archivo /tareasTaller-0.0.1-SNAPSHOT-jar-with-dependencies' de la carpeta /target. Para un correcto funcionamiento se debe tener instalado PostgreSQL + pgAdmin y modificar el persistence.xml con los datos "nombre database" y "contraseña database". Se recomienda también cargar por primera vez las tablas de 'Provincia' y 'Localidad' haciendo uso de los archivos .txt dentro de '/src/main/resources/loc-prov' (en orden: prov, loc1, loc2).
