package com.eduit.spring.clase3.dao;

import com.eduit.spring.clase3.model.Articulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


   /*
getBy , readBy , findBy

And	         findByLastnameAndFirstname	… where x.lastname = ?1 and x.firstname = ?2
Or	        findByLastnameOrFirstname	… where x.lastname = ?1 or x.firstname = ?2
Between	    findByStartDateBetween	… where x.startDate between 1? and ?2
LessThan	findByAgeLessThan	… where x.age < ?1
GreaterThan	findByAgeGreaterThan	… where x.age > ?1
After	    findByStartDateAfter	… where x.startDate > ?1
Before	    findByStartDateBefore	… where x.startDate < ?1
IsNull	    findByAgeIsNull	… where x.age is null
IsNotNull,NotNull	findByAge(Is)NotNull	… where x.age not null
Like	    findByFirstnameLike	… where x.firstname like ?1
NotLike	    findByFirstnameNotLike	… where x.firstname not like ?1
StartingWith	findByFirstnameStartingWith	… where x.firstname like ?1 (parameter bound with appended %)
EndingWith	  findByFirstnameEndingWith	… where x.firstname like ?1 (parameter bound with prepended %)
Containing	findByFirstnameContaining	… where x.firstname like ?1 (parameter bound wrapped in %)
OrderBy	findByAgeOrderByLastnameDesc	… where x.age = ?1 order by x.lastname desc
Not	findByLastnameNot	… where x.lastname <> ?1
In	findByAgeIn(Collection<Age> ages)	… where x.age in ?1
NotIn	findByAgeNotIn(Collection<Age> age)	… where x.age not in ?1
True	findByActiveTrue()	… where x.active = true
False	findByActiveFalse()	… where x.active = false

 */

    public interface ArticuloDAO extends CrudRepository<Articulo, Long>{



        public List<Articulo> findByNombre(String nombre);

        public List<Articulo> findByNombreAndPresentacion(String nombre,String presentacion);

        public List<Articulo> findByNombreOrPresentacion(String nombre,String presentacion);

    }



