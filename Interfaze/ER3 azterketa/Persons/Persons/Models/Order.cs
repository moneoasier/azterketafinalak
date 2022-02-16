using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.Models
{
    public class Order
    {
        [Key]
        public int OrderId { get; set; }
        public int OrderNumber { get; set; }
        public int PersonID { get; set; }
    }
}
