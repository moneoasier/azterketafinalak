using Microsoft.EntityFrameworkCore;
using Persons.Data.Migrations;
using Persons.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.Services
{
    public class PersonService : IPersonService
    {
        private readonly PersonsDbContext _context;

        public PersonService(PersonsDbContext context)
        {
            _context = context;
        }
        public async Task<Person> GetPersonById(int id)
        {
            return _context.Person.Find(id);
        }

        public async Task<IList<Person>> GetPersons()
        {
            return await _context.Person.ToListAsync();
        }
    }
}
