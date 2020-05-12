# mentoria_frontend

<h2>Objetivos</h2>

Este é um projeto realizado na linguagem Java que realiza testes nas páginas <a href="http://the-internet.herokuapp.com/iframe">IFrame1</a> e <a href="http://the-internet.herokuapp.com/nested_frames">IFrame2</a>. Avaliando assim os seguintes cenários:

1. Printar no console o conteúdo do iframe em IFrame1.
2. Printar no console o conteúdo de LEFT e MIDDLE em IFrame2.


<h2>Ferramentas utilizadas:</h2>

- <i>Selenium WebDriver para mapeamento dos objetos da página.</i>
- <i>TestNG para execução dos casos de teste.</i>


<h2>Para executar a automação:</h2>

1) Este é um projeto maven, portanto caso não possua a aplicação faça o <a href="https://maven.apache.org/download.cgi">download</a> no site:

	Extraia os arquivos para o diretório de sua preferência e adicione o diretório raiz ao path do sistema operacional.
	Ex: "C:\Users\<User>\apache-maven-3.6.1"
	
2) Aqui existem duas formas de carregar os arquivos no seu sistema :

	2.1) Clonar o repo via git, executar:
	
	  	git clone https://github.com/mcoradini/mentoria_frontend.git
		
	2.2) Ou faça o download do arquivo .zip e extraia o seu conteúdo em um diretório.
	
3) Importe o projeto na sua IDE. No eclipse:

	3.1) Acesse o menu "File -> Import...".
  
	3.2) Na janela Import, selecione "Maven -> Existing Maven Projects" e clique <Next>.
  
	3.3) Em "Root Directory" selecione o diretório no qual o clone foi realizado no passo 2.
  
	3.4) No campo "Projets" deve aparecer o arquivo pom do projeto. Marque o checkbox.
  
	3.5) Marque o checkbox "Add project(s) to working set" e em seguida clique em <Finish>.
	
	Aguarde o processo de importação ser finalizado.
	
4) Executando a suite de testes:  

	4.1) Clique sobre o arquivo "IFrameOperationsTestCase.java" e no menu de contexto selecione Run As -> TestNG Test.
	
	4.2) Ou acesse via CMD o local onde o projeto foi extraido e execute o comando:
				mvn test

OBS:
- <i>Na IDE Eclipse é necessário realizar a instalação do TestNG, em Help -> Install New Software"</i>
