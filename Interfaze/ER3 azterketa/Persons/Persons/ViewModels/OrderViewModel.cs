using Persons.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.ViewModels
{
    public class OrderViewModel
    {
        [Key]
        public int id { get; set; }
        public IList<Order> Orders { get; set; }
        public string PersonIzena { get; set; }
    }
}
