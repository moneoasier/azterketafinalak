using Microsoft.EntityFrameworkCore;
using Persons.Data.Migrations;
using Persons.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.Services
{
    public class OrderService : IOrderService
    {
        private readonly PersonsDbContext _context;
        public OrderService(PersonsDbContext personsDbContext)
        {
            _context = personsDbContext;
        }

        public async Task<IList<Order>> GetOrders()
        {
            return await _context.Order.ToListAsync();
        }

        public async Task InsertOrder(Order order)
        {
            _context.Order.Add(order);
            _context.SaveChanges();
        }

        public async Task<IList<Order>> getOrdersByPerson(int id)
        {
            return await _context.Order.Where(c => c.PersonID == id).ToListAsync();
        }
    }
}
