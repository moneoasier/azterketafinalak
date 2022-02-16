using Persons.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.Services
{
    public interface IPersonService
    {
        Task<IList <Person>> GetPersons();
        Task<Person> GetPersonById(int id);
    }
}
