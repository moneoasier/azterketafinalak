using Microsoft.AspNetCore.Mvc;
using Persons.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Persons.ViewComponents
{
    [ViewComponent(Name = "Order")]
    public class OrderViewComponent : ViewComponent
    {
        private readonly IOrderService _iOrderService;

        public OrderViewComponent(IOrderService iOrderService)
        {
            _iOrderService = iOrderService;

        }

        //Datuak gehitzeko da, datuak lista bat egiteko itzultzen dira.
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View(await _iOrderService.GetOrders());

        }

    }
}
