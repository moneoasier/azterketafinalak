using Persons.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.Services
{
    public interface IWineService
    {
        Task<IList<Person>> GetPersons();
    }
}
