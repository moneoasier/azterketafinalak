using Newtonsoft.Json;
using Persons.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace Persons.Services
{
    public class WineService : IWineService
    {
        private Uri rutaTodos = new Uri("https://localhost:44367/person");
        public async Task<IList<Person>> GetPersons()
        {
            List<Person> personList = new List<Person>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    personList = JsonConvert.DeserializeObject<List<Person>>(apiResponse);
                }
            }
            return personList;
        }
    }
}
