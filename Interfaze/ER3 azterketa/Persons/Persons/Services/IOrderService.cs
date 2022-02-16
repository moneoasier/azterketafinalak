using Persons.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.Services 
{
    public interface IOrderService
    {
        Task<IList<Order>> GetOrders();
        Task InsertOrder(Order order);
        Task<IList<Order>> getOrdersByPerson(int id);
        
    }
}
