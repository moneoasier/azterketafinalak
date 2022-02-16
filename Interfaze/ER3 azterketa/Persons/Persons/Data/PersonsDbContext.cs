using Microsoft.EntityFrameworkCore;
using Persons.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Persons.ViewModels;

namespace Persons.Data.Migrations
{
    public class PersonsDbContext : DbContext
    {
        public PersonsDbContext(DbContextOptions<PersonsDbContext> options)
            : base(options)
        {
        }

        public DbSet<Person> Person { get; set; }
        public DbSet<Order> Order { get; set; }
        public DbSet<Persons.ViewModels.OrderViewModel> OrderViewModel { get; set; }
    }
}
