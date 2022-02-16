using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Persons.Models;
using Persons.Services;
using Persons.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.Controllers
{
    public class PersonController : Controller
    {
        private readonly IPersonService _IPersonService;
        private readonly IOrderService _IOrderService;

        public PersonController(IPersonService iPersonService, IOrderService iOrderService)
        {
            _IPersonService = iPersonService;
            _IOrderService = iOrderService;
        }
        // GET: PersonController
        public async Task<ActionResult> Index()
        {
            ViewBag.izena = "pepe";
            IList<Person> personLista = await _IPersonService.GetPersons();
            return View(personLista);
        }

        //ViewModelera bidaltzen du data
        // GET: PersonController/Details/5
        public async Task<ActionResult> Details()
        {
            var p = await _IPersonService.GetPersonById(1);

            OrderViewModel orderViewModel = new OrderViewModel();
            orderViewModel.PersonIzena = p.FirstName;
            orderViewModel.Orders = await _IOrderService.getOrdersByPerson(1);
            return View(orderViewModel);
        }

        // GET: PersonController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: PersonController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: PersonController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: PersonController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: PersonController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: PersonController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
