package br.com.luizalexandrew.socketrelatorio;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico {

	private JFrame jf;
	private DefaultCategoryDataset ds;
	private JFreeChart chart;
	private String[] marcacoesGrafico;
	private ChartPanel panel;

	public Grafico() {
		this.jf = new JFrame();
		this.ds = new DefaultCategoryDataset();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(600, 480);
	}

	public void criarLinhasMarcadoras(String linhasMarcadoras) {
		this.marcacoesGrafico = linhasMarcadoras.split(",");
	}

	public void gerarGrafico() {
		this.chart = ChartFactory.createLineChart(this.marcacoesGrafico[0], this.marcacoesGrafico[1],
				this.marcacoesGrafico[2], this.ds, PlotOrientation.VERTICAL, true, true, true);
		this.panel = new ChartPanel(this.chart);
		CategoryItemRenderer renderer = this.chart.getCategoryPlot().getRenderer();
		renderer.setSeriesPaint(0, Color.BLACK);
		renderer.setSeriesPaint(1, Color.YELLOW);
		renderer.setSeriesPaint(2, Color.GREEN);
		renderer.setSeriesPaint(3, Color.BLUE);
		renderer.setSeriesPaint(4, Color.CYAN);
		renderer.setSeriesPaint(5, Color.ORANGE);
		jf.add(panel, BorderLayout.CENTER);
		jf.setVisible(true);
	}

	public void adicionaValorGrafico(String dados) {

		String[] vetDados = dados.split(",");
		Double valor = Double.parseDouble(vetDados[0]);

		this.ds.addValue(valor.doubleValue(), vetDados[1], vetDados[2]);

		this.chart = ChartFactory.createLineChart(this.marcacoesGrafico[0], this.marcacoesGrafico[1],
				this.marcacoesGrafico[2] + " - " + valor, this.ds, PlotOrientation.VERTICAL, true, true, true);
		this.panel = new ChartPanel(this.chart);

		CategoryItemRenderer renderer = this.chart.getCategoryPlot().getRenderer();
		renderer.setSeriesPaint(0, Color.BLACK);
		renderer.setSeriesPaint(1, Color.YELLOW);
		renderer.setSeriesPaint(2, Color.GREEN);
		renderer.setSeriesPaint(3, Color.BLUE);
		renderer.setSeriesPaint(4, Color.CYAN);
		renderer.setSeriesPaint(5, Color.ORANGE);
		jf.add(panel, BorderLayout.CENTER);
		jf.setVisible(true);

	}
}
