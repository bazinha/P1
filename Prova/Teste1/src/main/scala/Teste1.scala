import akka.actor._
import akka.routing.RoundRobinRouter
import scala.concurrent.duration._
import scala.io._
import java.io._
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.PrintWriter
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.InputStream
import java.io.Writer
import scala.collection.mutable.ArrayBuffer

sealed trait Mensagens
case object Comecar extends Mensagens
case object CriarArquivo extends Mensagens
case object LerArquivo extends Mensagens


class Arquivo()
{
    
        def criar_arquivo(nome:String): Unit = {
              var arquivo = new FileInputStream ("pimpar")
              var input = new InputStreamReader(arquivo)
              var br = new BufferedReader(input)
              var file = new File(nome + ".txt")
              var os = new FileOutputStream(nome + ".txt");
              var osw = new OutputStreamWriter(os);
              var bw = new BufferedWriter(osw);
              var linha = br.readLine()
              
            
              do{
                linha = br.readLine()
                if(linha != null){
                  if (linha.startsWith(nome)){
                  
                  bw.write(linha + "\n")
                  }
                }
              }
              while (linha != null)
              bw.close()
    }
    

    def criar_arquivo4(): Unit =
    {
        var arquivo = new FileInputStream ("pimpar")
        var input = new InputStreamReader(arquivo)
        var br = new BufferedReader(input)
        var file = new File("Usuario_Pid.txt")
        var os = new FileOutputStream("Usuario_Pid.txt");
        var osw = new OutputStreamWriter(os);
        var bw = new BufferedWriter(osw);
        var linha = br.readLine()
        var palavras = linha.split(" ")
        
        
        do{
            linha = br.readLine()
             
            if(linha != null)
                bw.write(palavras(0) + " " + palavras(1) + "\n")
                palavras = linha.split(" ")
        } while(linha != null)
        
        
            bw.close()
        }
        
    
 
    }
    


class Mestre extends Actor
{
    val worker1 = context.actorOf(Props[Apache], "worker1")
    val worker2 = context.actorOf(Props[Docker], "worker2")
    val worker3 = context.actorOf(Props[Java], "worker3")
    val worker4 = context.actorOf(Props[Mysql], "worker4")
    val worker5 = context.actorOf(Props[Postgres], "worker5")
    val worker6 = context.actorOf(Props[Root], "worker6")
    val worker7 = context.actorOf(Props[Stack], "worker7")
    val worker8 = context.actorOf(Props[Ubuntu], "worker8")
    
    override def receive: Receive = 
    {
        case Comecar =>
        {
           worker1 ! CriarArquivo
           worker2 ! CriarArquivo
           worker3 ! CriarArquivo
           worker4 ! CriarArquivo
           worker5 ! CriarArquivo
           worker6 ! CriarArquivo
           worker7 ! CriarArquivo
           worker8 ! CriarArquivo
        }
    }
    
}

class Apache extends Actor
{
     def receive: Receive =
    {
        case CriarArquivo => {
          val user1 = new Arquivo
          user1.criar_arquivo("apache")
          //user1.criar_arquivo2("apache")
          user1.criar_arquivo4()
           
        }
    }
}


class Docker extends Actor
{
    def receive: Receive = 
    {
        case CriarArquivo => 
        {
            val user2 = new Arquivo
            user2.criar_arquivo("docker")
            //user2.criar_arquivo2("docker")
        }
    }
}

class Java extends Actor
{
    def receive: Receive = 
    {
        case CriarArquivo =>
        {
            val user3 = new Arquivo
            user3.criar_arquivo("java")
            //user3.criar_arquivo2("java")
        }
    }
}

class Mysql extends Actor
{
    def receive: Receive = 
    {
        case CriarArquivo =>
        {
            val user4 = new Arquivo
            user4.criar_arquivo("mysql")
           // user4.criar_arquivo2("mysql")
        }
    }
}

class Postgres extends Actor
{
    def receive: Receive = 
    {
        case CriarArquivo =>
        {
            val user5 = new Arquivo
            user5.criar_arquivo("postgres")
           // user5.criar_arquivo2("postgres")
        }
    }
}

class Root extends Actor
{
    def receive: Receive = 
    {
        case CriarArquivo =>
        {
            val user6 = new Arquivo
            user6.criar_arquivo("root")
            //user6.criar_arquivo2("root")
        }
    }
}

class Stack extends Actor
{
    def receive: Receive = 
    {
        case CriarArquivo =>
        {
            val user7 = new Arquivo
            user7.criar_arquivo("stack")
            //user7.criar_arquivo2("stack")
        }
    }
}

class Ubuntu extends Actor
{
    def receive: Receive = 
    {
        case CriarArquivo =>
        {
            val user8 = new Arquivo
            user8.criar_arquivo("ubuntu")
            //user8.criar_arquivo2("ubuntu")
        }
    }
}




object Prova
{
    
    def main(args: Array[String]): Unit = {
        
        val system = ActorSystem("MainSystem")
        
        val prova = system.actorOf(Props[Mestre], "prova")
        
        prova ! Comecar
        
        
    }
}