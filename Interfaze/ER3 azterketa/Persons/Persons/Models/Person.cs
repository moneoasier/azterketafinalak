using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.Models
{
    public class Person
    {
        [Key]
        public int Id { get; set; }
        public String LastName { get; set; }
        public String FirstName { get; set; }
        public int Age { get; set; }
    }
}
