var ctxRam = document.getElementsByClassName("line-chart-ram")

var chartGraph = new Chart(ctxRam, {
    type: 'line',
    data: {
        labels: ["12h", "12h05", "12h10", "12h15", "12h20", "12h25", "12h30"],
        datasets: [{
            label: "Uso de Memória RAM",
            data: [70, 85, 55, 45, 27, 55, 82],
            borderWidth: 2,
            borderColor: 'rgba(79,255,92,0.85)',
            backgroundColor: 'transparent'
        }]
    },
    options: {
        title: {
            display: true,
            fontSize: 20,
            text: "Uso de Memória RAM"
        }
    }
})

var ctxCPU = document.getElementsByClassName("line-chart-cpu")

var chartGraph = new Chart(ctxCPU, {
    type: 'line',
    data: {
        labels: ["12h", "12h05", "12h10", "12h15", "12h20", "12h25", "12h30"],
        datasets: [{
            label: "Uso de CPU",
            data: [70, 85, 55, 45, 27, 55, 82],
            borderWidth: 2,
            borderColor: 'rgba(0,0,255,0.85)',
            backgroundColor: 'transparent'
        }]
    },
    options: {
        title: {
            display: true,
            fontSize: 20,
            text: "Uso de CPU"
        }
    }
})

var ctxDisco = document.getElementsByClassName("line-chart-disco")

var chartGraph = new Chart(ctxDisco, {
    type: 'line',
    data: {
        labels: ["12h", "12h05", "12h10", "12h15", "12h20", "12h25", "12h30"],
        datasets: [{
            label: "Uso de Disco",
            data: [70, 85, 55, 45, 27, 55, 82],
            borderWidth: 2,
            borderColor: 'rgba(255,0,0,0.85)',
            backgroundColor: 'transparent'
        }]
    },
    options: {
        title: {
            display: true,
            fontSize: 20,
            text: "Uso do Disco Rígido"
        }
    }
})

var ctxTodos = document.getElementsByClassName("pie-chart")

var chartGraph = new Chart(ctxTodos, {
    type: 'pie',
    data: {
        labels: ['CPU', 'Memória', 'Disco Rígido'],
        datasets: [
            {
                label: 'Points',
                backgroundColor: ['rgb(0,0,255)', 'rgb(79,255,92)', 'rgb(255,0,0)'],    
                data: [82, 82, 82,]
            }
        ]
    },
    options: {
        title: {
            display: true,
            fontSize: 20,
            text: "Monitoramento Geral"
        }
    }
})